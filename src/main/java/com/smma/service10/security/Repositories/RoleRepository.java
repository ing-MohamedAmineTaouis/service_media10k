package com.smma.service10.security.Repositories;

import com.smma.service10.security.Entities.Role;
import com.smma.service10.security.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Role findByRole(String name);
}
