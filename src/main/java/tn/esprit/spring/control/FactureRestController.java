package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.service.FactureService;

@RestController
@RequestMapping("/facture")
@Api(tags = "Gestion des Factures")
public class FactureRestController {
	@Autowired
	FactureService factureService;
	
	// http://localhost:8089/SpringMVC/facture/retrieve-all-factures
		@GetMapping("/retrieve-all-factures")
		@ResponseBody
		public List<Facture> getFactures() {
			List<Facture> listFactures= factureService.retrieveAllFactures();
		return listFactures; 
		}
		
		// http://localhost:8089/SpringMVC/facture/retrieve-facture/1
		@GetMapping("/retrieve-facture/{facture-id}")
		@ResponseBody
		public Facture retrieveFacture(@PathVariable("facture-id") Long factureId) {
			return factureService.retrieveFacture(factureId);
		}
		// http://localhost:8089/SpringMVC/facture/retrieve-facture/1
		@GetMapping("/retrieve-client-factures/{client-id}")
		@ResponseBody
		public List<Facture> getFacturesByClient(@PathVariable("client-id") Long idClient) {
			return factureService.getFacturesByClient(idClient);
		}
		
		
		// http://localhost:8089/SpringMVC/facture/add-facture
		@PostMapping("/add-facture")
		@ResponseBody
		public Facture addFacture(@RequestBody Facture f, Long idClient) 
		{
			Facture facture = factureService.addFacture(f, idClient);
			return facture;
		}
		
		// http://localhost:8089/SpringMVC/facture/remove-facture/{facture-id}
		@DeleteMapping("/delete-facture/{facture-id}")
		@ResponseBody
		public void deleteFacture(@PathVariable("facture-id") Long factureId) {
			factureService.deleteFacture(factureId);
		}
		
		// http://localhost:8089/SpringMVC/facture/cancel-facture/{facture-id}
		@PutMapping("/cancel-facture/{facture-id}")
		@ResponseBody
		public void cancelFacture(@PathVariable("facture-id") Long factureId) {
			factureService.cancelFacture(factureId);
		}
		
}
