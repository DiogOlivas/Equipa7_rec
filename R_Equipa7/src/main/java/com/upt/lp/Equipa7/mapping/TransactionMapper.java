package com.upt.lp.Equipa7.mapping;

import com.upt.lp.Equipa7.DTO.TransactionDTO;
import com.upt.lp.Equipa7.entity.Transaction;
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
                transaction.getPaymentMethod(),
                transaction.getCategory() != null ? transaction.getCategory().getName() : null
                
            );
        }
        //DTO TO ENTITY
       public static Transaction toEntity(TransactionDTO dto) {
        if (dto == null) return null;

        Transaction transaction = new Transaction();

        if (dto.getId() != null && dto.getId() != 0) {
            transaction.setId(dto.getId());
        }

        transaction.setValue(dto.getValue());

        // String → LocalDate
        transaction.setDate(LocalDate.parse(dto.getDate()));

        transaction.setDescription(dto.getDescription());

        // Categoria (assume 1ª da lista)
        if (dto.getCategory() != null && !dto.getCategory().isEmpty()) {
            Category category = new Category();
            category.setName(dto.getCategory());
            transaction.setCategory(category);
        }

        return transaction;
        }  
}
    


