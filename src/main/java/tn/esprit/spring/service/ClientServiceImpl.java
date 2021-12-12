package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.CategorieClient;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.FactureRepository;

@Service
@Slf4j
public class ClientServiceImpl implements ClientSerivce{
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	FactureRepository factureRepository;
	
	@Override
	public List<Client> retrieveAllClients() {
		List<Client> clients = (List<Client>) clientRepository.findAll();
		for(Client client : clients){
			log.info(" client : "+client);
		}
		return clients;
	}

	@Override
	public Client addClient(Client c) {
		Client client = clientRepository.save(c);
		return client;
	}

	@Override
	public void deleteClient(Long id) {
		clientRepository.deleteById(id);
		
	}

	@Override
	public Client updateClient(Client c) {
		Client client =clientRepository.save(c);
		return client;
	}

	@Override
	public Client retrieveClient(Long id) {
		Client client = clientRepository.findById(id).get();
		return client;
	}

	@Override
	public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {
		float cAffaire=0;
		List<Facture> factures = (List<Facture>) factureRepository.findAll();
		for (Facture f : factures )
		 {
			 if ( f.getDateFacture().after(startDate) && f.getDateFacture().before(endDate) && f.getClient().getCategorieClient() == categorieClient )
			 {
				 cAffaire += f.getMontantFacture();
			 }
		 }
		return cAffaire;
	}

	

	
	
}
