package com.kodilla.foodpairingbackend.facade;

import com.kodilla.foodpairingbackend.config.AdminConfig;
import com.kodilla.foodpairingbackend.domain.Mail;
import com.kodilla.foodpairingbackend.domain.dto.CompositionDto;
import com.kodilla.foodpairingbackend.domain.entity.Composition;
import com.kodilla.foodpairingbackend.exception.CommentNotFoundException;
import com.kodilla.foodpairingbackend.exception.CompositionNotFoundException;
import com.kodilla.foodpairingbackend.exception.DishNotFoundException;
import com.kodilla.foodpairingbackend.exception.DrinkNotFoundException;
import com.kodilla.foodpairingbackend.mapper.CompositionMapper;
import com.kodilla.foodpairingbackend.service.CompositionService;
import com.kodilla.foodpairingbackend.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CompositionFacade {

    private final CompositionService compositionService;
    private final CompositionMapper compositionMapper;
    private final EmailService emailService;
    private final AdminConfig adminConfig;

    public List<CompositionDto> getCompositions() {
        List<Composition> compositionList = compositionService.getCompositions();
        return compositionMapper.mapToCompositionDtoList(compositionList);
    }

    public CompositionDto getComposition(Long compositionId) throws CompositionNotFoundException {
        Composition composition = compositionService.getComposition(compositionId);
        return compositionMapper.mapToCompositionDto(composition);
    }

    public void deleteComposition(Long compositionId) {
        compositionService.deleteComposition(compositionId);
    }

    public CompositionDto createComposition(CompositionDto compositionDto) throws DrinkNotFoundException,
            DishNotFoundException, CompositionNotFoundException, CommentNotFoundException {
        Composition composition = compositionMapper.mapToComposition(compositionDto);
        Composition savedComposition = compositionService.saveComposition(composition);
        emailService.send(new Mail(
                        adminConfig.getAdminMail(),
                        "Foodpairing: New Composition appeared",
                        "New Composition which ID is " + composition.getId().toString() + " has been created in \"FOODPAIRING\" application",
                        null
                )
        );
        return compositionMapper.mapToCompositionDto(savedComposition);
    }

    public CompositionDto updateComposition(CompositionDto compositionDto) throws DrinkNotFoundException,
            DishNotFoundException, CompositionNotFoundException, CommentNotFoundException {
        Composition composition = compositionMapper.mapToComposition(compositionDto);
        Composition savedComposition = compositionService.saveComposition(composition);
        return compositionMapper.mapToCompositionDto(savedComposition);
    }
}
