package com.trifulcas.Hibernate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestionAlumnos estudiante = new GestionAlumnos();
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Entre un id de alumno: ");
		int id = teclado.nextInt();
		
		estudiante.LeerXid(id);
	}

}
