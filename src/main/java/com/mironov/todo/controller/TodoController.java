package com.mironov.todo.controller;

import com.mironov.todo.entity.TodoEntity;
import com.mironov.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {


    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/post/{id}")
    public ResponseEntity addTodo(@RequestBody TodoEntity todo, @RequestParam Long id){
        try {
            return ResponseEntity.ok(todoService.createTodo(todo,id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping()
    public ResponseEntity completeTodo(@RequestParam Long id){
        try {
            return ResponseEntity.ok(todoService.completeTodo(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
