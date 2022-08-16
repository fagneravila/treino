package com.avila.curso.resources;

import com.avila.curso.entities.Users;
import com.avila.curso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<Users>> findAll(){
         // teste  Users u = new Users(1L,"Fagner","fagner.avila@gmail.com","999999","123456");
           List<Users> list = service.findAll();
           return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Users> findById(@PathVariable Long id){
         Users obj = service.findById(id);
         return ResponseEntity.ok().body(obj);
    }
}
