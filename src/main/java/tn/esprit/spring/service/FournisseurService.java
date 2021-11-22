package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Fournisseur;

public interface FournisseurService {
	List<Fournisseur> retrieveAllFournisseurs();
	Fournisseur addFournisseur(Fournisseur c);
	void deleteFournisseur(Long id);
	Fournisseur updateFournisseur(Fournisseur c);
	Fournisseur retrieveFournisseur(Long id);
}
