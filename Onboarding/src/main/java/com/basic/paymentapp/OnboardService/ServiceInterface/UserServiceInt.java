package com.basic.paymentapp.OnboardService.ServiceInterface;

import com.basic.paymentapp.entities.Response;
import com.basic.paymentapp.entities.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServiceInt {
    public List<Response> getAlldata();
    public boolean addUser(Users user);
    public boolean updateuser(Users user);
    public Users getUserbyId(String Phoneno);
}
