package com.avila.curso.resources;

import com.avila.curso.entities.Users;
import com.avila.curso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Users> insert(@RequestBody Users obj){
         obj = service.insert(obj);
         URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
         return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
         service.delete(id);
         return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Users> update(@RequestBody Users obj, @PathVariable Long id){
        obj = service.update(id, obj);
       // URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.ok().body(obj);
    }

}
