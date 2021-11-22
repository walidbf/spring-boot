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
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.service.RayonService;

@RestController
@RequestMapping("/rayon")
@Api(tags = "Gestion des Rayons")
public class RayonRestController {
	@Autowired
	RayonService rayonService;
	
	@ApiOperation(value = "Récupérer la liste des rayons")
	// http://localhost:8089/SpringMVC/rayon/retrieve-all-rayons
	@GetMapping("/retrieve-all-rayons")
	@ResponseBody
	public List<Rayon> getRayons() {
		List<Rayon> listRayons= rayonService.retrieveAllRayons();
	return listRayons; 
	}
	
	@ApiOperation(value = "Récupérer un rayon")
	// http://localhost:8089/SpringMVC/rayon/retrieve-rayon/1
	@GetMapping("/retrieve-rayon/{rayon-id}")
	@ResponseBody
	public Rayon retrieveRayon(@PathVariable("rayon-id") Long rayonId) {
		return rayonService.retrieveRayon(rayonId);
	}
	
	@ApiOperation(value = "Ajouter un rayon")
	// http://localhost:8089/SpringMVC/rayon/add-rayon
	@PostMapping("/add-rayon")
	@ResponseBody
	public Rayon addRayon(@RequestBody Rayon c) 
	{
		Rayon rayon = rayonService.addRayon(c);
		return rayon;
	}
	
	@ApiOperation(value = "Supprimer un rayon")
	// http://localhost:8089/SpringMVC/rayon/remove-rayon/{rayon-id}
	@DeleteMapping("/remove-rayon/{rayon-id}")
	@ResponseBody
	public void removeRayon(@PathVariable("rayon-id") Long rayonId) {
		rayonService.deleteRayon(rayonId);
	}
	
	// http://localhost:8089/SpringMVC/rayon/modify-rayon
	@PutMapping("/modify-rayon")
	@ResponseBody
	public Rayon modifyRayon(@RequestBody Rayon rayon) {
		return rayonService.updateRayon(rayon);
	}
}
