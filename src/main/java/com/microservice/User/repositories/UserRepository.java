package com.microservice.User.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.User.models.User;

public interface UserRepository extends JpaRepository<User, UUID>  {

}
