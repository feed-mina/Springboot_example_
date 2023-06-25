package com.example.sotck.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sotck.repository.StockRepository;
import com.example.stock.domain.Stock;

@Service
public class StockService {

	private StockRepository stockRepository;
	
	public StockService(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}
	// get stock
			// 재고감소
			// 저장
			
	@Transactional
	public void decrease(Long id, Long quantity) {
		
	Stock stock = stockRepository.findById(id).orElseThrow();
	
	stock.decrase(quantity);
	
	stockRepository.saveAndFlush(stock);
	
	
	}
	
}
