package com.kodilla.foodpairingbackend.repository;

import com.kodilla.foodpairingbackend.domain.entity.Drink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface DrinkRepository extends CrudRepository<Drink, Long> {

    @Override
    List<Drink> findAll();
}
