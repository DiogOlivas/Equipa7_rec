package com.upt.lp.Equipa7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.upt.lp.Equipa7.entity.Category;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	Optional<Category> findByName(String name);
	Optional<Category> findById(Long id);
}