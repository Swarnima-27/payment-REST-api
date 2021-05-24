package com.basic.paymentapp.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class PassGen {

        public static void main(String[] args) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            System.out.println(encoder.encode("root"));
            System.out.println(encoder.encode("root1"));
    }
}
//$2a$10$/7g45cFoo.KWI7V1c7W5G.ef/t0N4P7ZnNOI33msCn7nWcwwfDAxO
//        $2a$10$s0Thd4ikXdKvjYRJcjhUb.EDbVko2scfX6p1BiLz91.JiME/ItIG2

//$2a$10$K6VESDbUDNf0ipVgldP3R.sJOm6ZlLybpMsGIsLfgKH0LgZquhA7u
//        $2a$10$dEdMDJB2tW1VAlPusyxNMOrp5MBNZ6QVLvV/QU11R2VegiCEtGJzu