package com.crud.fullstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.fullstack.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
