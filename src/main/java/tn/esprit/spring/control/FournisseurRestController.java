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
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.service.FournisseurService;

@RestController
@RequestMapping("/fournisseur")
@Api(tags = "Gestion des Fournisseurs")
public class FournisseurRestController {
	@Autowired
	FournisseurService fournisseurService;
	
	@ApiOperation(value = "Récupérer la liste des fournisseurs")
	// http://localhost:8089/SpringMVC/fournisseur/retrieve-all-fournisseurs
	@GetMapping("/retrieve-all-fournisseurs")
	@ResponseBody
	public List<Fournisseur> getFournisseurs() {
		List<Fournisseur> listFournisseurs= fournisseurService.retrieveAllFournisseurs();
	return listFournisseurs; 
	}
	
	@ApiOperation(value = "Récupérer un fournisseur")
	// http://localhost:8089/SpringMVC/fournisseur/retrieve-fournisseur/1
	@GetMapping("/retrieve-fournisseur/{fournisseur-id}")
	@ResponseBody
	public Fournisseur retrieveFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
		return fournisseurService.retrieveFournisseur(fournisseurId);
	}
	
	@ApiOperation(value = "Ajouter un fournisseur")
	// http://localhost:8089/SpringMVC/fournisseur/add-fournisseur
	@PostMapping("/add-fournisseur")
	@ResponseBody
	public Fournisseur addFournisseur(@RequestBody Fournisseur c) 
	{
		Fournisseur fournisseur = fournisseurService.addFournisseur(c);
		return fournisseur;
	}
	
	@ApiOperation(value = "Supprimer un fournisseur")
	// http://localhost:8089/SpringMVC/fournisseur/remove-fournisseur/{fournisseur-id}
	@DeleteMapping("/remove-fournisseur/{fournisseur-id}")
	@ResponseBody
	public void removeFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
		fournisseurService.deleteFournisseur(fournisseurId);
	}
	
	// http://localhost:8089/SpringMVC/fournisseur/modify-fournisseur
	@PutMapping("/modify-fournisseur")
	@ResponseBody
	public Fournisseur modifyFournisseur(@RequestBody Fournisseur fournisseur) {
		return fournisseurService.updateFournisseur(fournisseur);
	}
}
