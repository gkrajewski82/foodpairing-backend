package com.kodilla.foodpairingbackend.service;

import com.kodilla.foodpairingbackend.domain.entity.Drink;
import com.kodilla.foodpairingbackend.exception.DrinkNotFoundException;
import com.kodilla.foodpairingbackend.repository.DrinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrinkService {

    private final DrinkRepository drinkRepository;

    public List<Drink> getDrinks() {
        return drinkRepository.findAll();
    }

    public Drink getDrink(final Long drinkId) throws DrinkNotFoundException {
        return drinkRepository.findById(drinkId).orElseThrow(DrinkNotFoundException::new);
    }

    public void deleteDrink(final Long drinkId) {
        drinkRepository.deleteById(drinkId);
    }

    public Drink saveDrink(final Drink drink) {
        return drinkRepository.save(drink);
    }
}
