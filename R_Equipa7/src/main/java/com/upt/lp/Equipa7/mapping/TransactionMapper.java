package com.upt.lp.Equipa7.mapping;

import com.upt.lp.Equipa7.DTO.TransactionDTO;
import com.upt.lp.Equipa7.entity.Transaction;
import com.upt.lp.Equipa7.entity.User;
import com.upt.lp.Equipa7.repository.UserRepository;
import com.upt.lp.Equipa7.repository.CategoryRepository;
import com.upt.lp.Equipa7.entity.Category;


public class TransactionMapper {
	public static TransactionDTO toDTO(Transaction tx) {
	    if (tx == null) return null;

	    TransactionDTO dto = new TransactionDTO();
	    dto.setId(tx.getId());
	    dto.setDate(tx.getDate());
	    dto.setDescription(tx.getDescription());
	    dto.setValue(tx.getValue());
	    dto.setPaymentMethod(tx.getPaymentMethod());

	    dto.setUserId(
	        tx.getUser() != null ? tx.getUser().getId() : null
	    );

	    dto.setCategoryId(
	        tx.getCategory() != null ? tx.getCategory().getId() : null
	    );

	    return dto;
	}
     // DTO TO ENTITY
        public static Transaction toEntity(TransactionDTO dto, UserRepository userRepository, CategoryRepository categoryRepository) {
            if (dto == null) return null;

            Transaction transaction = new Transaction();

            if (dto.getId() != null && dto.getId() != 0) {
                transaction.setId(dto.getId());
            }

            transaction.setValue(dto.getValue());

            if (dto.getDate() != null) {
                transaction.setDate(dto.getDate());
            }

            transaction.setDescription(dto.getDescription());
            transaction.setPaymentMethod(dto.getPaymentMethod());

            if (dto.getCategoryId() != null) {
                Category category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));

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
    


