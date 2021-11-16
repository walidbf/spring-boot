package tn.esprit.spring.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.repository.FactureRepository;

@Service
@Slf4j
public class FactureServiceImpl implements FactureService{
	@Autowired
	FactureRepository factureRepository;
	@Override
	public List<Facture> retrieveAllFactures() {
		List<Facture> factures = (List<Facture>) factureRepository.findAll();
		
		return factures;
	}

	@Override
	public void cancelFacture(Long id) {
		//if(factureRepository.findById(id).get().getActive()){
		//	factureRepository.findById(id).get().setActive(false);
		//}
		Facture facture = factureRepository.findById(id).orElse(null);
		facture.setActive(false);
		factureRepository.save(facture);
		
	}

	@Override
	public Facture retrieveFacture(Long id) {
		Facture facture = factureRepository.findById(id).get();
		return facture;
	}

}
