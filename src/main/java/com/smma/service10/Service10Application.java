package com.smma.service10;

import com.smma.service10.security.Services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Service10Application {

	public static void main(String[] args) {
		SpringApplication.run(Service10Application.class, args);
	}
	@Bean
	public CommandLineRunner demo(AccountService accountService) {
		return args -> {
			//accountService.CreateUser("admin","123","admin@gmail.com","123");
//            accountService.CreateUser("amine","123","amine@gmail.com","123");
////            accountService.CreateRole("ADMIN");
////            accountService.CreateRole("CLIENT");
//
//            accountService.AddRoleToUser("admin","ADMIN");
//            accountService.AddRoleToUser("amine","CLIENT");
            //System.out.println(accountService.loadUserByUsername("admin").getEmail());
		};
	}

}
