package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Rayon;

public interface RayonService {
	List<Rayon> retrieveAllRayons();
	Rayon addRayon(Rayon c);
	void deleteRayon(Long id);
	Rayon updateRayon(Rayon c);
	Rayon retrieveRayon(Long id);
}
