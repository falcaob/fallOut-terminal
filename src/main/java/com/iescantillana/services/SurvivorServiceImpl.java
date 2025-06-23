package com.iescantillana.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iescantillana.models.Survivor;
import com.iescantillana.repositories.SurvivorRepository;

@Service
public class SurvivorServiceImpl implements SurvivorService{
	
	@Autowired
	private SurvivorRepository survivorRepo;

	@Override
	public List<Survivor> getAllSurvivors() {
		return survivorRepo.findAll();
	}

	@Override
	public Survivor findById(Long id) {
		Optional<Survivor> opt = survivorRepo.findById(id);
		Survivor survivor = null;
		if(opt.isPresent()) {
			survivor = opt.get(); //carga datos de la bd
		} else {
			throw new RuntimeException("Superviviente no encontrado");
		}
		return survivor;
		//return survivorRepo.findById(id).orElse(null);
	}

	@Override
	public void save(Survivor survivor) {
		survivorRepo.save(survivor);
		
	}

	@Override
	public void delete(Long id) {
		survivorRepo.deleteById(id);
		
	}

}
