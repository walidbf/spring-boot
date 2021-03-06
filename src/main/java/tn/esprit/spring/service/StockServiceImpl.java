package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.StockRepository;

@Service
@Slf4j
public class StockServiceImpl implements StockService {
	@Autowired
	StockRepository stockRepository;
	@Override
	public List<Stock> retrieveAllStocks() {
		List<Stock> stocks = (List<Stock>) stockRepository.findAll();
		 for(Stock stock : stocks){
				log.info(" stock : "+stock.toString());
			}
			return stocks;
	}
	
	/*//TP Schedular
	@Scheduled(fixedDelay=60000)//en milliseconde //or fixedRate 
	public void alertLowStock(){
		List<Stock> stocks = (List<Stock>) stockRepository.findAll();
		for (Stock s : stocks)
		{
			if (s.getQteStock()<= s.getQteMin())
				log.info("Attention repture de stock : " +s.getLibelleStock());
		}
	}
	*/
	
	@Override
	public Stock addStock(Stock s) {
		log.info("in method add stock : ");
	return	stockRepository.save(s);
		
	}

	@Override
	public Stock updateStock(Stock u) {
		Stock stock = stockRepository.save(u);
		return stock;
	}

	@Override
	public Stock retrieveStock(Long id) {
		Stock stock=null;
		try{
			log.info("In method retrieveStock : ");
			log.debug("Je veux me connecter à la base : ");
			stock = stockRepository.findById(id).orElse(null);
			//int i = 1/0;
			log.debug("le stock : "+stock);
			log.info("Out method retrieveStock without errors");
		}
		catch (Exception e) {
			log.error("Error in retrieveStock");
		}
		return stock;
		
	}

	@Override
	public void deleteStock(Long id) {
		stockRepository.deleteById(id);
		
	}
	@Scheduled(cron = "0 28 21 * * *")
	@Override
	public void retrieveStatusStock() {
		List<Stock> stocks = (List<Stock>) stockRepository.findAll();
		for (Stock s : stocks)
		{
			if (s.getQteStock()<= s.getQteMin())
				log.info("Attention repture de stock : " +s.getLibelleStock());
		}
		
	}
	

}
