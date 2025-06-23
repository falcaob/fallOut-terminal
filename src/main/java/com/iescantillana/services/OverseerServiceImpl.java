package com.iescantillana.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iescantillana.models.Overseer;
import com.iescantillana.repositories.OverseerRepository;

@Service
public class OverseerServiceImpl implements OverseerServiceI{
	
	@Autowired
	private OverseerRepository overseerRepo;
	
	@Override
	public List<Overseer> getAllOverseers() {
		return overseerRepo.findAll();
	}

	@Override
	public Overseer findById(Long id) {
		return overseerRepo.findById(id).orElse(null);
	}

}
