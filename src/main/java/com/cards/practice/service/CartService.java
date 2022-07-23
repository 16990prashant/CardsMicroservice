package com.cards.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cards.practice.entity.Cards;
import com.cards.practice.repository.CardsRepository;



@Service
public class CartService {
	
	@Autowired
	private CardsRepository cardsRepository;

	public List<Cards> getDetails(Integer id) {
		List<Cards> card = cardsRepository.findByCustomerId(id);				
	if (card.size()> 0 ) {
		return card;
	} else {
		throw new RuntimeException("Card not found with customer id : " + id);
	}
	}
}

