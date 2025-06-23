package com.iescantillana.services;

import java.util.List;

import com.iescantillana.models.Overseer;

public interface OverseerServiceI {
	
	// Obtener todos los supervidores
	List<Overseer> getAllOverseers();
	
	// Obtener supervisor por id
	Overseer findById(Long id);

}
