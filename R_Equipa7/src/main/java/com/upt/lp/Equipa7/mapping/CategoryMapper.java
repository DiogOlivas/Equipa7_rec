package com.upt.lp.Equipa7.mapping;

import java.util.stream.Collectors;

import com.upt.lp.Equipa7.DTO.CategoryDTO;
import com.upt.lp.Equipa7.entity.Category;
import com.upt.lp.Equipa7.entity.User;
import com.upt.lp.Equipa7.repository.UserRepository;

public class CategoryMapper {


	public static CategoryDTO toDTO(Category cat) {
		if (cat == null) return null;
		return new CategoryDTO(
				cat.getId(),
	            cat.getUser() != null ? cat.getUser().getId() : null,
				cat.getName(),
				cat.getDesc(),
				cat.getBudget(),
				cat.getTransactions() == null ? null :
		            cat.getTransactions().stream()
		                .map(t -> t.getId())
		                .collect(Collectors.toList())
				); 
	}

	public static Category toEntity(CategoryDTO dto) {
	    Category c = new Category();
	    c.setName(dto.getName());
	    c.setDesc(dto.getDesc());
	    c.setBudget(dto.getBudget());
	    return c;
	}
}
