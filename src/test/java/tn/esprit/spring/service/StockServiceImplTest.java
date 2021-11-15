package tn.esprit.spring.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Stock;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {
	@Autowired
	StockService stockService;
	@Test
	public void testAddStock() {
		Stock S = new Stock("stock test",10,100);
		Stock savedStock = stockService.addStock(S);
		assertEquals(S.getLibelleStock(),savedStock.getLibelleStock());
	}
	
	@Test
	public void testDeleteStock(){
		stockService.deleteStock((long) 13);
		assertNull(stockService.retrieveStock((long) 13));
	}
	
	
	@Test
	public void testRetrieveAllStock(){
		List<Stock> allStock = stockService.retrieveAllStocks();
		assertEquals(8,allStock.size());
	}
	
	@Test
	public void testRetrieveStock(){
		Stock s = stockService.retrieveStock(11L);
		assertEquals("stock test",s.getLibelleStock());
	}
}
