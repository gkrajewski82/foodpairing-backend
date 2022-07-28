package com.kodilla.foodpairingbackend.mapper;

import com.kodilla.foodpairingbackend.domain.dto.DishDto;
import com.kodilla.foodpairingbackend.domain.entity.Dish;
import com.kodilla.foodpairingbackend.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DishMapper {

    private final CompositionMapper compositionMapper;

    public Dish mapToDish(DishDto dishDto) throws DrinkNotFoundException, DishNotFoundException,
            CompositionNotFoundException, CommentNotFoundException {
        return new Dish(
                dishDto.getId(),
                dishDto.getExternalSystemId(),
                dishDto.getName(),
                dishDto.getReadyInMinutes(),
                dishDto.getServings(),
                dishDto.getRecipeUrl(),
                compositionMapper.mapToCompositionList(dishDto.getCompositionList())
        );
    }

    public DishDto mapToDishDto(Dish dish) {
        return new DishDto(
                dish.getId(),
                dish.getExternalSystemId(),
                dish.getName(),
                dish.getReadyInMinutes(),
                dish.getServings(),
                dish.getRecipeUrl(),
                compositionMapper.mapToCompositionDtoList(dish.getCompositionList())
        );
    }

    public List<Dish> mapToDishList(final List<DishDto> dishDtoList) throws DrinkNotFoundException,
            CompositionNotFoundException, DishNotFoundException, CommentNotFoundException {
        List<Dish> dishList = new ArrayList<>();
        for (DishDto dishDto : dishDtoList) {
            Dish dish = mapToDish(dishDto);
            dishList.add(dish);
        }
        return dishList;
    }

    public List<DishDto> mapToDishDtoList(final List<Dish> dishList) {
        return dishList.stream()
                .map(this::mapToDishDto)
                .collect(Collectors.toList());
    }
}
