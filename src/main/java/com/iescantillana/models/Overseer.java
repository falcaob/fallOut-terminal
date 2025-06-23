package com.iescantillana.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Overseer {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOverseer;
	
	@Column(nullable = false, length = 50)
	private String username;
	
	@Column(nullable = false, length = 8)
	private String password;
	
	@OneToMany(mappedBy = "overseer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Survivor> survivor;

}
