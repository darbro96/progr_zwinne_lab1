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
	
	public Integer getZadanieId() {
		return zadanieId;
	}
	public void setZadanieId(Integer zadanieId) {
		this.zadanieId = zadanieId;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public int getKolejnosc() {
		return kolejnosc;
	}
	public void setKolejnosc(int kolejnosc) {
		this.kolejnosc = kolejnosc;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public LocalDateTime getDataczasOddania() {
		return dataczasOddania;
	}
	public void setDataczasOddania(LocalDateTime dataczasOddania) {
		this.dataczasOddania = dataczasOddania;
	}
	public Projekt getProjekt() {
		return projekt;
	}
	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}
	
	
}