package com.upt.lp.Equipa7.mapping;

import java.util.stream.Collectors;

import com.upt.lp.Equipa7.DTO.CategoryDTO;
import com.upt.lp.Equipa7.entity.Category;

public class CategoryMapper {


	public static CategoryDTO toDTO(Category cat) {
		if (cat == null) return null;
		return new CategoryDTO(
				cat.getId(),
				cat.getUser(),
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
		 if (dto == null) return null;
	 	Category cat = new Category();
	 	cat.setId(dto.getId() != null ? dto.getId() : 0); 
	 	cat.setName(dto.getNome());
	 	return cat;
	 }
}
