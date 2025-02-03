package com.mironov.todo.service;

import com.mironov.todo.entity.UserEntity;
import com.mironov.todo.exception.UserAlreadyExistException;
import com.mironov.todo.exception.UserNotFoundException;
import com.mironov.todo.model.UserModel;
import com.mironov.todo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("already exist");
        }
        return userRepo.save(user);
    }

    public UserModel findUser(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user == null){
            throw new UserNotFoundException("user not found");
        }
        return UserModel.toModel(user);
    }

    public Long deleteUser(Long id) throws UserNotFoundException {
        userRepo.deleteById(id);
        return id;
    }

    public List<UserEntity> findAllUsers() throws UserNotFoundException{
        return userRepo.findAll();
    }
}
