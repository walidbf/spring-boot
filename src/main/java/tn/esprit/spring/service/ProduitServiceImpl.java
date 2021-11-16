package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.repository.ProduitRepository;

@Service
@Slf4j
public class ProduitServiceImpl implements ProduitService {
	@Autowired
	ProduitRepository produitRepository;

	@Override
	public List<Produit> retrieveAllProduits() {
		List<Produit> produits = (List<Produit>)produitRepository.findAll();
		return produits;
	}

	@Override
	public Produit addProduit(Produit p, Long idRayon, Long idStock) {
		Produit produit = produitRepository.save(p);
		return produit;
	}

	@Override
	public Produit retrieveProduit(Long id) {
		Produit produit = produitRepository.findById(id).get();
		return produit;
	}
	
}
