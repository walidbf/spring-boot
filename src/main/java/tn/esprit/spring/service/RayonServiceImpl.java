package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.repository.RayonRepository;

@Service
@Slf4j
public class RayonServiceImpl implements RayonService{
	@Autowired
	RayonRepository rayonRepository;
	@Override
	public List<Rayon> retrieveAllRayons() {
		List<Rayon> rayons = (List<Rayon>) rayonRepository.findAll();
		for(Rayon rayon : rayons){
			log.info(" rayon : "+rayon);
		}
		return rayons;
	}

	@Override
	public Rayon addRayon(Rayon c) {
		Rayon rayon = rayonRepository.save(c);
		return rayon;
	}

	@Override
	public void deleteRayon(Long id) {
		rayonRepository.deleteById(id);
		
	}

	@Override
	public Rayon updateRayon(Rayon c) {
		Rayon rayon =rayonRepository.save(c);
		return rayon;
	}

	@Override
	public Rayon retrieveRayon(Long id) {
		Rayon rayon = rayonRepository.findById(id).get();
		return rayon;
	}
}
