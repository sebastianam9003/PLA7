package com.trifulcas.Hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


@Entity
@Table(name="profesores")
public class Profesores {
	@Id
	@Column(name="idprofesor")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idprofesor;
	
	@Column(name="dni")
	private String dni;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="email")
	private String email;
	
	@OneToMany (mappedBy="profesores", cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Modulos> modulo;
	
	//Constructores
	public Profesores() { }
	public Profesores(String nombre) {
		super();
		this.nombre = nombre;
	}
	public Profesores(String nombre, String dni, String email) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.email = email;
	}
	
	//getter and setter
	public int getIdprofesor() {
		return idprofesor;
	}

	public void setIdprofesor(int idprofesor) {
		this.idprofesor = idprofesor;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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
	
	public List<Modulos> getModulo(){
		return modulo;
	}
	
	public void setModulo(List<Modulos> modulo) {
		this.modulo = modulo;
	}
}
