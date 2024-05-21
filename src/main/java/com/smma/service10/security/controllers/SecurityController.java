package com.smma.service10.security.controllers;

import com.smma.service10.security.Entities.Role;
import com.smma.service10.security.Entities.User;
import com.smma.service10.security.Repositories.UserRepository;
import com.smma.service10.security.Services.AccountService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class SecurityController {
    private final UserRepository userRepository;
    private AccountService accountService;
    private final BCryptPasswordEncoder passwordEncoder; // Add this line

    public SecurityController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String index(){
        return "redirect:/productsList";
    }
    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "/AccessDenied";
    }
    @RequestMapping("/signup")
    public String signup(){
        return "Signup";
    }
    @RequestMapping("/register")
    public String SaveNewUser(@ModelAttribute("user") User user, BindingResult result){
        System.out.println("Processing registration form...");

        if (result.hasErrors()) {
            System.out.println("Binding errors: " + result.getAllErrors());
            return "login"; // Return to the registration form if there are errors
        }
        // Check if the username is already taken
        if (userRepository.findByUsername(user.getUsername()) != null) {
            System.out.println("Username is already taken: " + user.getUsername());
            result.rejectValue("username", "error.user", "Username is already taken");
            return "login"; // Return to the registration form if the username is taken
        }
        // Set necessary properties of the Customer object from the User object
        List<Role> roleList =new ArrayList<>();
        Role role = new Role("CLIENT");
        roleList.add(role);
        user.setRoles(roleList);
        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("Saving user: " + user);
        user.setUserId(UUID.randomUUID().toString());// from yahya s help
        // Save the user
        userRepository.save(user);
        System.out.println("User saved: " + user);
        return "login";
    }

}
