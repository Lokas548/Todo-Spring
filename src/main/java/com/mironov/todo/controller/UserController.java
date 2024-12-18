package com.mironov.todo.controller;


import com.mironov.todo.entity.TodoEntity;
import com.mironov.todo.entity.UserEntity;
import com.mironov.todo.exception.UserAlreadyExistException;
import com.mironov.todo.exception.UserNotFoundException;
import com.mironov.todo.repository.UserRepo;
import com.mironov.todo.service.TodoService;
import com.mironov.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try{
            userService.registration(user);
            return ResponseEntity.ok().body("Пользователь сохранен");
        }catch (UserAlreadyExistException e ){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("error");
        }

    }

    @GetMapping
    public ResponseEntity getUser(@RequestParam Long id){
        try{
            return ResponseEntity.ok(userService.findUser(id));
        }
        catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("error");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try{
            return ResponseEntity.ok(userService.deleteUser(id));
        }
        catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("error");
        }
    }

}
