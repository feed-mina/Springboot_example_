package com.example.stock.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.sotck.repository.StockRepository;
import com.example.sotck.service.StockService;
import com.example.stock.domain.Stock;

@SpringBootTest 
public class StockServiceTest {

	@Autowired
	private StockService stockService;
	
	@Autowired
	private StockRepository stockRepository;
	
	@BeforeEach
	public void before() {
		Stock stock = new Stock(1L,100L);
		stockRepository.saveAndFlush(stock);
	}
	
	@AfterEach
	public void after() {
		stockRepository.deleteAll();
	}
	
	@Test
	public void stock_decrease() {
		stockService.decrease(1L, 1L);
		
		// 100 - 1 = 99
	Stock stock =	stockRepository.findById(1L).orElseThrow();
	assertEquals(99, stock.getQuantity());
	}
}
