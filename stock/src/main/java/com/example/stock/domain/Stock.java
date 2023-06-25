package com.example.stock.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stock {

	// id, productId, quantity
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long prudctId;
	
	private Long quantity;
	
	public Stock() {
		
	}
	
	public Stock(Long prudctId, Long quantity) {
		this.prudctId = prudctId;
		this.quantity = quantity;
	}
	
	public Long getQuantity() {
		return quantity;
	}
	
	public void decrase(Long quantity) {
		if(this.quantity - quantity <0) {
			throw new RuntimeException("foo");
		}
		this.quantity = this.quantity - quantity;
	}
	
}
