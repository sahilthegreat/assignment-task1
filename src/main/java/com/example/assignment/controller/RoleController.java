package com.example.assignment.controller;
import com.example.assignment.model.Role;
import com.example.assignment.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getroles(){
        List<Role> roles = roleService.getRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<Role> getRole(@PathVariable("id") Long id){
        Role role = roleService.getRole(id);
        return new ResponseEntity<>(role,HttpStatus.OK);
    }

    @PostMapping("/roles")
    public ResponseEntity<Role> addRole(@RequestBody Role role){
        roleService.addRole(role);
        return new ResponseEntity<>(role,HttpStatus.CREATED);
    }

    @DeleteMapping("/roles/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable("id") Long id){
        roleService.deleteRole(id);
        return ResponseEntity.ok("Role deleted with id: " + id);
    }

}
