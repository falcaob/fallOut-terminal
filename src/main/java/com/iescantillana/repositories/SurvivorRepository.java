package com.iescantillana.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iescantillana.models.Survivor;

public interface SurvivorRepository extends JpaRepository<Survivor, Long> {

}
