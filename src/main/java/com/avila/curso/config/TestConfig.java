package com.avila.curso.config;

import com.avila.curso.entities.Users;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {


    Users u1 = new Users(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
    Users u2 = new Users(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

}
