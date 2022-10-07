package com.example.assignment.service;

import com.example.assignment.exception.ResourceNotFoundException;
import com.example.assignment.model.Role;
import com.example.assignment.model.User;
import com.example.assignment.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepo roleRepo;
    public List<Role> getRoles() {
       return roleRepo.findAll();
    }

    public Role getRole(Long id) {
        return roleRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not exist with id: " + id));
    }

    public void addRole(Role role) {
        roleRepo.save(role);
    }

    public void deleteRole(Long id) {
        Role role = getRole(id);
        roleRepo.delete(role);
    }

}
