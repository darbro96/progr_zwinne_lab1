package com.project.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "projekt") // potrzebne tylko je¿eli nazwa tabeli w bazie danych ma byæ inna od nazwy klasy
public class Projekt {
	@Id
	@GeneratedValue
	@Column(name = "projekt_id") // tylko je¿eli nazwa kolumny w bazie danych ma byæ inna od nazwy zmiennej
	private Integer projektId;
	@Column(nullable = false, length = 50)
	private String nazwa;
	@CreationTimestamp
	@Column(name = "dataczas_utworzenia", nullable = false, updatable = false)
	private LocalDateTime dataczasUtworzenia;
	@Column(name = "data_oddania")
	private LocalDate dataOddania;
	@OneToMany(mappedBy = "projekt")
	private List<Zadanie> zadania;
	@ManyToMany
	@JoinTable(name = "projekt_student", joinColumns = { @JoinColumn(name = "projekt_id") }, inverseJoinColumns = {
			@JoinColumn(name = "student_id") })
	private Set<Student> studenci;

	public Projekt() {
	}

	public Integer getProjektId() {
		return projektId;
	}

	public void setProjektId(Integer projektId) {
		this.projektId = projektId;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public LocalDateTime getDataczasUtworzenia() {
		return dataczasUtworzenia;
	}

	public void setDataczasUtworzenia(LocalDateTime dataczasUtworzenia) {
		this.dataczasUtworzenia = dataczasUtworzenia;
	}

	public LocalDate getDataOddania() {
		return dataOddania;
	}

	public void setDataOddania(LocalDate dataOddania) {
		this.dataOddania = dataOddania;
	}

	public List<Zadanie> getZadania() {
		return zadania;
	}

	public void setZadania(List<Zadanie> zadania) {
		this.zadania = zadania;
	}

	public Set<Student> getStudenci() {
		return studenci;
	}

	public void setStudenci(Set<Student> studenci) {
		this.studenci = studenci;
	}

}