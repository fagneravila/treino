package com.avila.curso.repositories;

import com.avila.curso.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<Users, Long> {
}
