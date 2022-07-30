package com.kodilla.foodpairingbackend.facade;

import com.kodilla.foodpairingbackend.domain.dto.DishDto;
import com.kodilla.foodpairingbackend.domain.entity.Dish;
import com.kodilla.foodpairingbackend.exception.CommentNotFoundException;
import com.kodilla.foodpairingbackend.exception.CompositionNotFoundException;
import com.kodilla.foodpairingbackend.exception.DishNotFoundException;
import com.kodilla.foodpairingbackend.exception.DrinkNotFoundException;
import com.kodilla.foodpairingbackend.mapper.DishMapper;
import com.kodilla.foodpairingbackend.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DishFacade {

    private final DishService dishService;
    private final DishMapper dishMapper;

    public List<DishDto> getDishes() {
        List<Dish> dishList = dishService.getDishes();
        return dishMapper.mapToDishDtoList(dishList);
    }

    public DishDto getDish(Long dishId) throws DishNotFoundException {
        Dish dish = dishService.getDish(dishId);
        return dishMapper.mapToDishDto(dish);
    }

    public void deleteDish(Long dishId) {
        dishService.deleteDish(dishId);
    }

    public DishDto saveDishInDb(DishDto dishDto) throws DrinkNotFoundException,  DishNotFoundException,
            CompositionNotFoundException, CommentNotFoundException {
        Dish dish = dishMapper.mapToDish(dishDto);
        Dish savedDish = dishService.saveDish(dish);
        return dishMapper.mapToDishDto(savedDish);
    }

    public DishDto updateDish(DishDto dishDto) throws DrinkNotFoundException,  DishNotFoundException,
            CompositionNotFoundException, CommentNotFoundException {
        Dish dish = dishMapper.mapToDish(dishDto);
        Dish savedDish = dishService.saveDish(dish);
        return dishMapper.mapToDishDto(savedDish);
    }
}
