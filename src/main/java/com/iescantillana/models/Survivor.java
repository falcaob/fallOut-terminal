package com.iescantillana.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Survivor {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSurvivor;
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 50)
	private String sex;
	
	@Column(columnDefinition = "INTEGER(2)")
	private int age;
	
	@Column
	private boolean disease;
	
	@ManyToOne
	@JoinColumn(name = "id_overseer")
	private Overseer overseer;

}
