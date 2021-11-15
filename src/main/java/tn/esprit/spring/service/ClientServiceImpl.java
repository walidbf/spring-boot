package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.repository.ClientRepository;

@Service
@Slf4j
public class ClientServiceImpl implements ClientSerivce{
	@Autowired
	ClientRepository clientRepository;
			

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

	

	
	
}
