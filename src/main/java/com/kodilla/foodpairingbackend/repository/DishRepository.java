package com.kodilla.foodpairingbackend.repository;

import com.kodilla.foodpairingbackend.domain.entity.Composition;
import com.kodilla.foodpairingbackend.domain.entity.Dish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface DishRepository extends CrudRepository<Dish, Long> {

    @Override
    List<Dish> findAll();
}
