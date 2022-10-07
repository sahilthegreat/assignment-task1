package com.example.assignment.service;

import com.example.assignment.exception.ResourceNotFoundException;
import com.example.assignment.model.Role;
import com.example.assignment.model.User;
import com.example.assignment.repo.RoleRepo;
import com.example.assignment.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final static Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User getUser(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + id));
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public void deleteUser(Long id) {
        User user = getUser(id);
        userRepo.delete(user);
    }

    public void updateUser(Long id, User user) {
        User existUser = getUser(id);

        existUser.setName(user.getName());
        existUser.setAge(user.getAge());
        existUser.setEmail(user.getEmail());
        existUser.setContact(user.getContact());

        userRepo.save(existUser);
    }

    public void mapUserRole(Long userId, Long roleId) {
        User user = getUser(userId);
        Role role = roleRepo.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role does not exist with id: " + roleId));
        user.setRole(role);
        userRepo.save(user);
        logger.info(user.toString());
    }
}
