package com.upt.lp.Equipa7.mapping;

import com.upt.lp.Equipa7.DTO.TransactionDTO;
import com.upt.lp.Equipa7.entity.Transaction;
import com.upt.lp.Equipa7.entity.User;
import com.upt.lp.Equipa7.repository.UserRepository;
import com.upt.lp.Equipa7.entity.Category;
import java.time.LocalDate;


//
public class TransactionMapper {
    //ENTITY TO DTO
        public static TransactionDTO toDTO(Transaction transaction){
            if( transaction == null) return null;

             return new TransactionDTO(
                transaction.getId(),
                transaction.getValue(),
                transaction.getDate().toString(), 
                transaction.getDescription(),
                transaction.getUser() != null ? transaction.getUser().getId() : null,
                transaction.getPaymentMethod(),
                transaction.getCategory() != null ? transaction.getCategory().getName() : null
                
            );
        }
     // DTO → ENTITY
        public static Transaction toEntity(TransactionDTO dto, UserRepository userRepository) {
            if (dto == null) return null;

            Transaction transaction = new Transaction();

            if (dto.getId() != null && dto.getId() != 0) {
                transaction.setId(dto.getId());
            }

            transaction.setValue(dto.getValue());

            if (dto.getDate() != null && !dto.getDate().isEmpty()) {
                transaction.setDate(LocalDate.parse(dto.getDate()));
            }

            transaction.setDescription(dto.getDescription());
            transaction.setPaymentMethod(dto.getPaymentMethod());

            if (dto.getCategory() != null && !dto.getCategory().isEmpty()) {
                Category category = new Category();
                category.setName(dto.getCategory());
                transaction.setCategory(category);
            }

            if (dto.getUserId() != null) {
                User user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
                transaction.setUser(user);
            }

            return transaction;
        }
}
    


