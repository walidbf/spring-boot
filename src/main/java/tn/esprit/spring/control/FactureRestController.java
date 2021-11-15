package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.service.FactureService;

@RestController
@RequestMapping("/facture")
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
		
		
		// http://localhost:8089/SpringMVC/facture/remove-facture/{facture-id}
		@DeleteMapping("/cancel-facture/{facture-id}")
		@ResponseBody
		public void cancelFacture(@PathVariable("facture-id") Long factureId) {
			factureService.cancelFacture(factureId);
		}
		
}
