package com.trifulcas.Hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name="alumnos")
public class Alumnos {
	@Id
	@Column(name="idalumno")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idalumno;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="email")
	private String email;

	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch=FetchType.LAZY)
	@JoinTable(name="mod_alu", joinColumns = @JoinColumn(name="idalumno"), inverseJoinColumns = @JoinColumn(name="idmodulo"))
	private List<Modulos> modulos;
	
	
	//Constructores
	public Alumnos() { }
	public Alumnos(String nombre) {
		super();
		this.nombre = nombre;
	}
	public Alumnos(String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email;
	}
	
	
	
	//getter and setter
	public int getIdalumno() {
		return idalumno;
	}

	public void setIdalumno(int idalumno) {
		this.idalumno = idalumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Modulos> getModulos(){
		return modulos;
	}
	
	public void setModulos(List<Modulos> modulo) {
		this.modulos = modulo;
	}
	public void addModulo(Modulos modulo) {
		if (modulos == null) {
			modulos = new ArrayList<Modulos>();
		}
		modulos.add(modulo);
	}
	
}
