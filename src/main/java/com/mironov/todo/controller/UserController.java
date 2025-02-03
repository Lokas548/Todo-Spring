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
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    private final TodoService todoService;

    public UserController(UserService userService, TodoService todoService) {
        this.userService = userService;
        this.todoService = todoService;
    }

    @PostMapping("/registration")
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

    @GetMapping("/get-user")
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

    @DeleteMapping("/delete-user/{id}")
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

    @GetMapping("/get-all-users")
    public ResponseEntity getAllUsers(){
        try {
            return ResponseEntity.ok(userService.findAllUsers());
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
