
package com.upt.lp.Equipa7.service;

import com.upt.lp.Equipa7.DTO.ChangePasswordDTO;
import com.upt.lp.Equipa7.DTO.RegisterUserDTO;
import com.upt.lp.Equipa7.DTO.UserDTO;
import com.upt.lp.Equipa7.entity.User;
import com.upt.lp.Equipa7.entity.Transaction;
import com.upt.lp.Equipa7.entity.Category;
import com.upt.lp.Equipa7.repository.UserRepository;
import com.upt.lp.Equipa7.repository.TransactionRepository;
import com.upt.lp.Equipa7.repository.CategoryRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import com.upt.lp.Equipa7.entity.UserType;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepository,TransactionRepository transactionRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
        this.categoryRepository = categoryRepository;
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

    public void changePassword(User user, ChangePasswordDTO dto) {

        if (!encoder.matches(dto.oldPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Wrong password");
        }

        user.setPassword(encoder.encode(dto.newPassword()));
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
