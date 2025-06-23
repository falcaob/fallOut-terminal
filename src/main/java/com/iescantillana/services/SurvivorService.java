package com.iescantillana.services;

import java.util.List;

import com.iescantillana.models.Survivor;

public interface SurvivorService {
	
	// Listas todos los supervivientes
	List<Survivor> getAllSurvivors();
	
	// Obtener superviviente por id
	Survivor findById(Long id);
	
	// Insertar/Actualizar superviviente
	void save(Survivor survivor);
	
	// Eliminar superviviente
	void delete(Long id);

}
