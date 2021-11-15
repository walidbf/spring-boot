package tn.esprit.spring.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.CategorieClient;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Profession;
import tn.esprit.spring.entity.Stock;;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceImplTest {
	@Autowired
	ClientSerivce clientService;
	
	@Test
	//pour tester log file , fichier dans la repertoire
	public void testAddClient() {
		clientService.retrieveAllClients();
	}
	
}
