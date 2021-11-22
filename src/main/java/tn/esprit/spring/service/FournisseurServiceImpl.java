package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.repository.FournisseurRepository;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {
	@Autowired
	FournisseurRepository fournisseurRepository;
	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {
		List<Fournisseur> fournisseurs = (List<Fournisseur>) fournisseurRepository.findAll();
		for(Fournisseur fournisseur : fournisseurs){
			log.info(" fournisseur : "+fournisseur);
		}
		return fournisseurs;
	}

	@Override
	public Fournisseur addFournisseur(Fournisseur c) {
		Fournisseur fournisseur = fournisseurRepository.save(c);
		return fournisseur;
	}

	@Override
	public void deleteFournisseur(Long id) {
		fournisseurRepository.deleteById(id);
		
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur c) {
		Fournisseur fournisseur =fournisseurRepository.save(c);
		return fournisseur;
	}

	@Override
	public Fournisseur retrieveFournisseur(Long id) {
		Fournisseur fournisseur = fournisseurRepository.findById(id).get();
		return fournisseur;
	}
}
