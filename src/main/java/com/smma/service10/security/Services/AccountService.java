package com.smma.service10.security.Services;

import com.smma.service10.security.Entities.Role;
import com.smma.service10.security.Entities.User;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    User CreateUser(String username, String password, String email,String ConfirmPassword);
    Role CreateRole(String newRole);
    void AddRoleToUser(String username, String newRole);
    void RemoveRoleFromUser(String username, String newRole);
    User loadUserByUsername(String username);
    User GetUserByUsername(String username);
}
