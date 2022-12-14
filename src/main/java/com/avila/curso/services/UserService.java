package com.avila.curso.services;

import com.avila.curso.entities.Users;
import com.avila.curso.repositories.UserRepository;
import com.avila.curso.services.exceptions.DatabaseException;
import com.avila.curso.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> findAll(){
        return userRepository.findAll();
    }

    public Users findById(Long id){
        Optional<Users> obj = userRepository.findById(id);
        //return obj.get();
        return obj.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public Users insert(Users obj){
        return userRepository.save(obj);
    }

    public void delete(Long id){
        try {
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            //e.printStackTrace();
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Users update(Long id, Users obj){
        Users entity = userRepository.getReferenceById(id);
        updateData(entity,obj);
        return userRepository.save(entity);
    }

    private void updateData(Users entity, Users obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }


}
