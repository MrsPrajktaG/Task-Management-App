package com.maven.Services.impl;

import com.maven.Model.Role;
import com.maven.Model.User;
import com.maven.Repository.RoleRepository;
import com.maven.Repository.UserRepository;
import com.maven.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User login(User user) {
        return userRepository.getUserByEmailAndPassword(user.getEmail(),user.getPassword());
    }

    @Override
    public List<User> GetAllUser() {
        return userRepository.findAll();
    }
}
