package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Facture;

public interface FactureService {
	List<Facture> retrieveAllFactures();
	void cancelFacture(Long id);
	void deleteFacture(Long id);
	Facture retrieveFacture(Long id);
	List<Facture> getFacturesByClient(Long idClient);
	Facture addFacture(Facture f, Long idClient);
}
