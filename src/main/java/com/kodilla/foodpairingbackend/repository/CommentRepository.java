package com.kodilla.foodpairingbackend.repository;

import com.kodilla.foodpairingbackend.domain.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
