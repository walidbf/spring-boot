package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.service.ProduitService;

@RestController
@RequestMapping("/produit")
public class ProduitRestController {
	@Autowired
	ProduitService produitService;
	// http://localhost:8089/SpringMVC/produit/retrieve-all-produits
		@GetMapping("/retrieve-all-produits")
		@ResponseBody
		public List<Produit> getProduits() {
			List<Produit> listProduits= produitService.retrieveAllProduits();
		return listProduits; 
		}
		
		// http://localhost:8089/SpringMVC/produit/retrieve-produit/1
		@GetMapping("/retrieve-produit/{produit-id}")
		@ResponseBody
		public Produit retrieveProduit(@PathVariable("produit-id") Long produitId) {
			return produitService.retrieveProduit(produitId);
		}
		
		// http://localhost:8089/SpringMVC/produit/add-produit
		@PostMapping("/add-produit")
		@ResponseBody
		public Produit addProduit(@RequestBody Produit p, Long idRayon, Long idStock) 
		{
			Produit produit = produitService.addProduit(p,idRayon,idStock);
			return produit;
		}
		
}
