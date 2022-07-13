package com.kodilla.foodpairingbackend.repository;

import com.kodilla.foodpairingbackend.domain.entities.DrinkIngredients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface DrinkIngredientsRepository extends CrudRepository<DrinkIngredients, Long> {
}
