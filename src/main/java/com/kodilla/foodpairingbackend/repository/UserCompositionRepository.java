package com.kodilla.foodpairingbackend.repository;

import com.kodilla.foodpairingbackend.domain.entities.UserComposition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserCompositionRepository extends CrudRepository<UserComposition, Long> {
}
