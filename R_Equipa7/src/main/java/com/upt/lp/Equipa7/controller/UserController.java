package com.upt.lp.Equipa7.controller;

import com.upt.lp.Equipa7.DTO.ChangeBudgetDTO;
import com.upt.lp.Equipa7.DTO.ChangeEmailDTO;
import com.upt.lp.Equipa7.DTO.ChangePasswordDTO;
import com.upt.lp.Equipa7.DTO.LoginUserDTO;
import com.upt.lp.Equipa7.DTO.RegisterUserDTO;
import com.upt.lp.Equipa7.entity.User;
import com.upt.lp.Equipa7.repository.UserRepository;
import com.upt.lp.Equipa7.service.UserService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

    @RestController
    @RequestMapping("/users")
    public class UserController{
        private final UserService userService;
        private final AuthenticationManager authenticationManager;
        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        
        public UserController(UserService userService, AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder passwordEncoder) {
			this.userService = userService;
			this.authenticationManager = authenticationManager;
			this.userRepository = userRepository;
			this.passwordEncoder = passwordEncoder;
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

        	Map<String, Object> response = Map.of(
        			"id", user.getId(),
        		    "username", user.getUsername()
        	);

        		    return ResponseEntity.ok(response);	
        }
        
        @PostMapping("/change-email")
        public String changeEmail(@RequestBody ChangeEmailDTO dto) {
            if (dto.getNewEmail() == null || dto.getNewEmail().isBlank()) {
                return "ERROR: Email cannot be empty";
            }
            if (dto.getUserId() == null) return "ERROR: User ID missing";

            User user = userRepository.findById(dto.getUserId()).orElse(null);
            if (user == null) return "ERROR: User not found";

            user.setEmail(dto.getNewEmail());
            userRepository.save(user);

            return "SUCCESS";
        }

        @PostMapping("/change-password")
        public String changePassword(@RequestBody ChangePasswordDTO dto) {
            if (dto.getOldPassword() == null || dto.getOldPassword().isBlank() ||
                dto.getNewPassword() == null || dto.getNewPassword().isBlank()) {
                return "ERROR: Passwords cannot be empty";
            }
            if (dto.getUserId() == null) return "ERROR: User ID missing";

            User user = userRepository.findById(dto.getUserId()).orElse(null);
            if (user == null) return "ERROR: User not found";

            if (!passwordEncoder.matches(dto.getOldPassword(), user.getPassword())) {
                return "ERROR: Old password incorrect";
            }

            user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
            userRepository.save(user);

            return "SUCCESS";
        }

        @PostMapping("/change-budget")
        public String changeBudget(@RequestBody ChangeBudgetDTO dto) {
            if (dto.getNewBudget() == null) return "ERROR: Budget cannot be empty";
            if (dto.getUserId() == null) return "ERROR: User ID missing";

            User user = userRepository.findById(dto.getUserId()).orElse(null);
            if (user == null) return "ERROR: User not found";

            user.setBudget(dto.getNewBudget());
            userRepository.save(user);

            return "SUCCESS";
        }

}
