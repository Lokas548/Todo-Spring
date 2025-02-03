package com.mironov.todo.service;

import com.mironov.todo.entity.TodoEntity;
import com.mironov.todo.entity.UserEntity;
import com.mironov.todo.exception.UserAlreadyExistException;
import com.mironov.todo.repository.TodoRepo;
import com.mironov.todo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public TodoEntity createTodo(TodoEntity entity,Long id) throws UserAlreadyExistException {
        UserEntity user = userRepo.findById(id).get();
        entity.setUser(user);
        return todoRepo.save(entity);
    }

    public TodoEntity completeTodo(Long id) throws UserAlreadyExistException {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.isCompleted());
        return todoRepo.save(todo);
    }

}
