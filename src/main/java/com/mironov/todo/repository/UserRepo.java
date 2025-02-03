package com.mironov.todo.repository;

import com.mironov.todo.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    List<UserEntity> findAll();
}
