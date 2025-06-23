package com.iescantillana.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iescantillana.models.Overseer;

@Repository
public interface OverseerRepository extends JpaRepository<Overseer, Long> {
	
	Optional<Overseer> findByUsername(String username);

}
