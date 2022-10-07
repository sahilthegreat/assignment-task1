package com.example.assignment.controller;

import com.example.assignment.model.User;
import com.example.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id){
        User user = userService.getUser(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted with id: " + id);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        userService.updateUser(id, user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("users/{userId}/roles/{roleId}")
    public ResponseEntity<String> mapRoleToUser(@PathVariable("userId") Long userId, @PathVariable("roleId")Long roleId){
        userService.mapUserRole(userId,roleId);
        return ResponseEntity.ok("role mapped with user");
    }

}
