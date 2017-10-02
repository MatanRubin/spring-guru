package com.solaredge.recipes.repositories;

import com.solaredge.recipes.domain.Recipe;
import com.solaredge.recipes.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
