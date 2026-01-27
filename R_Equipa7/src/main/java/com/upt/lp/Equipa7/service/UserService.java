
package com.upt.lp.Equipa7.service;

import com.upt.lp.Equipa7.DTO.ChangeBudgetDTO;
import com.upt.lp.Equipa7.DTO.ChangeEmailDTO;
import com.upt.lp.Equipa7.DTO.ChangePasswordDTO;
import com.upt.lp.Equipa7.DTO.RegisterUserDTO;
import com.upt.lp.Equipa7.entity.User;
import com.upt.lp.Equipa7.repository.UserRepository;

import jakarta.validation.constraints.NotBlank;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    private final org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder encoder, PasswordEncoder passwordEnconder) {
        this.userRepository = userRepository;
		this.encoder = encoder;
		this.passwordEncoder = passwordEnconder;
    }

    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        return userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    
    public void register(RegisterUserDTO dto) {

        if (userRepository.existsByUsername(dto.username())) {
            throw new IllegalStateException("Username already exists");
        }
        
        if(userRepository.findByEmail(dto.email()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
        
        User user = new User();
        user.setUsername(dto.username());
        user.setPassword(encoder.encode(dto.password())); 
        user.setEmail(dto.email());

        userRepository.save(user);
    }

	public User findByUsername(@NotBlank String username) {
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("User not found"));
	}
	
	  @Transactional
	    public void changePassword(ChangePasswordDTO dto) {
	        User user = userRepository.findById(dto.getUserId())
	                .orElseThrow(() -> new RuntimeException("User not found"));

	        if (!passwordEncoder.matches(dto.getOldPassword(), user.getPassword())) {
	            throw new RuntimeException("Old password does not match");
	        }

	        user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
	        userRepository.save(user);
	    }
	  
    @Transactional
    public void changeEmail(User user, ChangeEmailDTO dto) {
        if ((dto.getNewEmail()).equals(user.getEmail())) {
            throw new IllegalArgumentException("New email must be different.");
        }
        if (userRepository.existsByEmail(dto.getNewEmail())) {
            throw new IllegalArgumentException("Email already in use.");
        }
        user.setEmail(dto.getNewEmail());
        userRepository.save(user);
    }

    @Transactional
    public User changeBudget(ChangeBudgetDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setBudget(dto.getNewBudget());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
