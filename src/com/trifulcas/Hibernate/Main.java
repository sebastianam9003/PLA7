package com.trifulcas.Hibernate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestionAlumnos pringado = new GestionAlumnos();
		Scanner teclado = new Scanner(System.in);
		
		
		System.out.println("Entre un id de alumno: ");
		int idalumno = teclado.nextInt();
		/*
		* System.out.println("Entre un dni de profesor: ");
		* String dni = teclado.nextLine();
		* System.out.println("Entre un email de profesor: ");
		* String email = teclado.nextLine();
		*/
		System.out.println("Entre un id de un modulo: ");
		int idmodulo = teclado.nextInt();
		
		//asignatura.LeerXid(id);
		//asignatura.LeerTodo();
		pringado.InsertarModulo(idalumno, idmodulo);
	}

}
