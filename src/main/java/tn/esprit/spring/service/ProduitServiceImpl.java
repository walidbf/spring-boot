package tn.esprit.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.RayonRepository;
import tn.esprit.spring.repository.StockRepository;

@Service
@Slf4j
public class ProduitServiceImpl implements ProduitService {
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	RayonRepository rayonRepository;
	@Autowired
	StockRepository stockRepository;
	@Autowired
	

	@Override
	public List<Produit> retrieveAllProduits() {
		List<Produit> produits = (List<Produit>)produitRepository.findAll();
		return produits;
	}

	@Transactional
	public Produit addProduit(Produit p, Long idRayon, Long idStock) {
		Rayon rayon = rayonRepository.findById(idRayon).orElse(null);
		Stock stock = stockRepository.findById(idStock).orElse(null);
		
		p.setRayon(rayon);
		p.setStock(stock);
		
		Produit produit = produitRepository.save(p);
		return produit;
	}
	
	@Scheduled(fixedRate=3000)//en milliseconde //or fixedDelay 
	public void fixedRateMethod(){
		log.info("Method with fixed Rate");
	}

	@Override
	public Produit retrieveProduit(Long id) {
		Produit produit = produitRepository.findById(id).get();
		return produit;
	}

	@Override
	public void ajouterProduitEtDetailproduit(Produit p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouterProduitEtAffecterRayon(Produit p, Long idRayon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affecterProduitARayon(Long idproduit, Long idRayon) {
		// TODO Auto-generated method stub
		
	}
	
}
