package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Produit;


public interface ProduitService {
	List<Produit> retrieveAllProduits();
	Produit addProduit(Produit p, Long idRayon, Long idStock);
	Produit retrieveProduit(Long id);
	Produit ajouterProduitEtDetailproduit(Produit p); //cascade
	Produit ajouterProduitEtAffecterRayon(Produit p,Long idRayon);
	void affecterProduitARayon(Long idproduit, Long idRayon);
	void assignProduitToStock(Long idProduit, Long idStock);
	void assignFournisseurToProduit(Long fournisseurId, Long produitId) ;
	float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);
}
