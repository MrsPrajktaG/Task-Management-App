package com.maven.Services;

import com.maven.Model.Role;
import com.maven.Model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    Role addRole(Role role);

    User login(User user);

    List<User> GetAllUser();


}
