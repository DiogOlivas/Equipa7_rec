package com.upt.lp.Equipa7.controller;

import com.upt.lp.Equipa7.DTO.RegisterUserDTO;
import com.upt.lp.Equipa7.DTO.UserDTO;
import com.upt.lp.Equipa7.entity.User;
import com.upt.lp.Equipa7.service.UserService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

    @RestController
    @RequestMapping("/users")
    public class UserController{
        private final UserService userService;

        public UserController(UserService userService){
            this.userService = userService;
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
        public ResponseEntity<String> login() {
            return ResponseEntity.ok("Login successful");
        }
        
        @PutMapping("/{id}")
        public User update(@PathVariable Long id, @RequestBody UserDTO dto) {
            return userService.updateUser(id, dto);
        }

        @DeleteMapping("/{id}") 
        public void delete(@PathVariable Long id){
            userService.deleteUser(id);
        }
}
