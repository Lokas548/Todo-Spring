package com.mironov.todo.repository;

import com.mironov.todo.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TodoRepo extends CrudRepository<TodoEntity,Long> {
}
