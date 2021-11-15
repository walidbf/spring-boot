package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Stock;

public interface StockRepository extends CrudRepository<Stock, Long> {
	
}
