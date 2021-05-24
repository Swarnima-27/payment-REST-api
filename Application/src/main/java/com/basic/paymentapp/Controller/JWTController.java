package com.basic.paymentapp.Controller;

import com.basic.paymentapp.model.JWTrequest;
import com.basic.paymentapp.model.JWTresponse;
import com.basic.paymentapp.services.MyUserDetailsService;
import com.basic.paymentapp.util.JWTutil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JWTController {

    private static final Logger log= LoggerFactory.getLogger(JWTController.class);

    @Autowired
     AuthenticationManager authenticationManager;

    @Autowired
     MyUserDetailsService userDetailsService;

    @Autowired
    JWTutil jwtutil;

    @PostMapping("/auth")
    public ResponseEntity<?> generateToken(@RequestBody JWTrequest jwtrequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtrequest.getUsername(), jwtrequest.getPassword())
            );
        } catch (BadCredentialsException e){
            log.error("Authorization failed");
            throw new Exception("Incorrect Username or Password");
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtrequest.getUsername());

        final  String jwt= jwtutil.generateToken(userDetails);
        log.info("JWT TOKEN : " + jwt );

        System.out.println("Authorization API Success");

        return ResponseEntity.ok(new JWTresponse(jwt));
    }
}
