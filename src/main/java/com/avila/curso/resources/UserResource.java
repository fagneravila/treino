package com.avila.curso.resources;

import com.avila.curso.entities.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<Users> findAll(){
           Users u = new Users(1L,"Fagner","fagner.avila@gmail.com","999999","123456");

           return ResponseEntity.ok().body(u);
    }
}
