package com.solaredge.recipes.repositories;

import com.solaredge.recipes.domain.Category;
import com.solaredge.recipes.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
