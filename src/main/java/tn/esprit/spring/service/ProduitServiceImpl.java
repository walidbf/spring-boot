package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.FactureRepository;
import tn.esprit.spring.repository.FournisseurRepository;
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
	FournisseurRepository fournisseurRepository;
	@Autowired
	FactureRepository factureRepository;

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
	/*
	@Scheduled(fixedRate=3000)//en milliseconde //or fixedDelay 
	public void fixedRateMethod(){
		log.info("Method with fixed Rate");
	}
	*/
	@Override
	public Produit retrieveProduit(Long id) {
		Produit produit = produitRepository.findById(id).get();
		return produit;
	}

	@Override
	public Produit ajouterProduitEtDetailproduit(Produit p) {
		Produit produit = produitRepository.save(p);
		return produit;
		
	}

	@Override
	public Produit ajouterProduitEtAffecterRayon(Produit p, Long idRayon) {
		Rayon rayon = rayonRepository.findById(idRayon).orElse(null);
		p.setRayon(rayon);
		Produit produit = produitRepository.save(p);
		return produit;
	}

	@Override
	public void affecterProduitARayon(Long idproduit, Long idRayon) {
		Produit produit = produitRepository.findById(idproduit).orElse(null);
		Rayon rayon = rayonRepository.findById(idRayon).orElse(null);
		produit.setRayon(rayon);
	}

	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		Produit produit = produitRepository.findById(idProduit).orElse(null);
		Stock stock = stockRepository.findById(idStock).orElse(null);
		produit.setStock(stock);
	}

	@Override
	public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
		Produit produit = produitRepository.findById(produitId).orElse(null);
		Fournisseur fournisseur = fournisseurRepository.findById(fournisseurId).orElse(null);
		Set<Fournisseur> fournisseurProd =  produit.getProduitsfor();
		fournisseurProd.add(fournisseur);
		produit.setProduitsfor(fournisseurProd);
	}

	@Override
	public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
		float cAffaire=0;
		List<Facture> factures = (List<Facture>) factureRepository.findAll();
		for (Facture f : factures )
		 {
			 if ( f.getDateFacture().after(startDate) && f.getDateFacture().before(endDate))
			 {   
				 Set<DetailFacture> detailsFactures = f.getDetailFacture();
				 
				 for (DetailFacture dFact : detailsFactures){
					 if(dFact.getProduit().getIdProduit() == idProduit)
					 {
						 cAffaire += dFact.getPrixTotal();
					 }
				 }
			 }
		 }
		return cAffaire;
	}
	
}
