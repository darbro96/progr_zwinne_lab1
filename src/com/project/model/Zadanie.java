package com.project.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "zadanie")
public class Zadanie {
	@Id
	@GeneratedValue
	@Column(name = "zadanie_id")
	private Integer zadanieId;
	@Column(name = "nazwa", nullable = false, length = 50)
	private String nazwa;
	@Column(name = "kolejnosc")
	private int kolejnosc;
	@Column(name = "opis", length = 1000)
	private String opis;
	@Column(name = "dataczas_oddania", nullable = false)
	private LocalDateTime dataczasOddania;
	@ManyToOne
	@JoinColumn(name = "projekt_id")
	private Projekt projekt;

}