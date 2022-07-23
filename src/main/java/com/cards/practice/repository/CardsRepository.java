package com.cards.practice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cards.practice.entity.Cards;

public interface CardsRepository extends JpaRepository<Cards, Integer> {

	List<Cards> findByCustomerId(Integer id);
}
