package com.upt.lp.Equipa7.controller;

import com.upt.lp.Equipa7.DTO.ChangePasswordDTO;
import com.upt.lp.Equipa7.DTO.LoginUserDTO;
import com.upt.lp.Equipa7.DTO.RegisterUserDTO;
import com.upt.lp.Equipa7.entity.User;
import com.upt.lp.Equipa7.repository.UserRepository;
import com.upt.lp.Equipa7.service.UserService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

    @RestController
    @RequestMapping("/users")
    public class UserController{
        private final UserService userService;
        private final AuthenticationManager authenticationManager;
        
        public UserController(UserService userService, AuthenticationManager authenticationManager) {
			this.userService = userService;
			this.authenticationManager = authenticationManager;
		}
        
		@GetMapping 
        public List<User> getAll(){
            return userService.getAllUsers();
        }
        @GetMapping("/{id}")
        public User getById(@PathVariable Long id){
            return userService.getUser(id);
        }

        @PostMapping("/register")
        public ResponseEntity<Void> register(
            @RequestBody @Valid RegisterUserDTO dto
        ) {
            userService.register(dto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    
        @PostMapping("/login")
        public ResponseEntity<Map<String, Object>> login(
                @RequestBody @Valid LoginUserDTO dto) {

        		authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    dto.username(),
                    dto.password()
                )
            );
        		
        	User user = userService.findByUsername(dto.username());

        	// Return JSON with user ID and username
        	Map<String, Object> response = Map.of(
        			"id", user.getId(),
        		    "username", user.getUsername()
        	);

        		    return ResponseEntity.ok(response);	
            //return ResponseEntity.ok("Login successful");
        }
        
        @PostMapping("/change-password")
        public ResponseEntity<String> changePass(
                @Valid @RequestBody ChangePasswordDTO dto,
                Authentication authentication
        ) {
            User user = (User) authentication.getPrincipal();

            userService.changePassword(user, dto);

            return ResponseEntity.ok("Password changed successfully");
        }

        @DeleteMapping("/{id}") 
        public void delete(@PathVariable Long id){
            userService.deleteUser(id);
        }
}
