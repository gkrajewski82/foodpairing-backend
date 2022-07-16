package com.kodilla.foodpairingbackend.repository;

import com.kodilla.foodpairingbackend.domain.entity.Composition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CompositionRepository extends CrudRepository<Composition, Long> {

    @Override
    List<Composition> findAll();
}
