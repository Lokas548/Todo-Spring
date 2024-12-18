package com.mironov.todo.repository;

import com.mironov.todo.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;


public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
