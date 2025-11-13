package com.clara.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository; // importación de JpaRepository
import com.clara.entity.User;

@Repository // indica que es un repositorio de datos
public interface UserRepository extends JpaRepository<User, Long> { // JpaRepository proporciona métodos CRUD para la entidad User

   
} 
