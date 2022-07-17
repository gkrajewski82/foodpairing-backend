package com.kodilla.foodpairingbackend.service;

import com.kodilla.foodpairingbackend.domain.dto.DishDto;
import com.kodilla.foodpairingbackend.domain.entity.Dish;
import com.kodilla.foodpairingbackend.exception.DishNotFoundException;
import com.kodilla.foodpairingbackend.mapper.DishMapper;
import com.kodilla.foodpairingbackend.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    public DishDto getDish(final Long dishId) throws DishNotFoundException {
        Dish dish = dishRepository.findById(dishId).orElseThrow(DishNotFoundException::new);
        return dishMapper.mapToDishDto(dish);
    }

    public void deleteDish(final Long dishId) {
        dishRepository.deleteById(dishId);
    }

    public DishDto saveDish(final DishDto dishdto) {
        Dish dish = dishMapper.mapToDish(dishdto);
        Dish savedDish = dishRepository.save(dish);
        return dishMapper.mapToDishDto(savedDish);
    }
}
