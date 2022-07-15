package com.kodilla.foodpairingbackend.repository;

import com.kodilla.foodpairingbackend.domain.entity.DrinkIngredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface DrinkIngredientRepository extends CrudRepository<DrinkIngredient, Long> {
}
