package com.cards.practice.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cards.practice.config.CardsCinfig;
import com.cards.practice.entity.Cards;
import com.cards.practice.entity.Customer;
import com.cards.practice.response.CardsResponseBo;
import com.cards.practice.service.CartService;

@RestController
public class CartController {

	
	@Autowired
	private CartService cardService;
	
	@Autowired
	private CardsCinfig cardsConfig;
	
	@PostMapping("/myCards")	
	public List<Cards> getCardDetails(@RequestBody Customer theCustomer) {		
		return cardService.getDetails(theCustomer.getCustomerId());
	}
	
	@GetMapping("/cards/properties")
	public CardsResponseBo getAllCardsConfigProperties() {
		CardsResponseBo cardsResponse = new CardsResponseBo();
		BeanUtils.copyProperties(cardsConfig,cardsResponse);
		return cardsResponse;	
	}
}