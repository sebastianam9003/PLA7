package com.trifulcas.Hibernate;
import java.util.Scanner;

public class Main {
	public static void LecturaAlumnos() {
		GestionAlumnos estudiante = new GestionAlumnos();
		Scanner teclado = new Scanner(System.in);
		int opcionleer = 0;
		do {
			System.out.println("MENU LECTURA ALUMNOS.\n");
			System.out.println("1.  Mostrar todos los Alumnos.");
			System.out.println("2.  Mostrar Alumno buscando por su identificador.");
			System.out.println("3.  Mostrar Alumno buscando por su nombre.\n");
			System.out.println("0.  SALIR.\n");
			System.out.print("Eloja opción del 0 al 3:  ");
			
			opcionleer = teclado.nextInt();
			String a = teclado.nextLine();
			
			switch(opcionleer) {
			case 1: estudiante.LeerTodo();
					break;
			case 2: System.out.println("Introduce un identificador de alumno valido: ");
					int idalumno = teclado.nextInt();
					String b = teclado.nextLine();
					estudiante.LeerXid(idalumno);
					break;
			case 3: System.out.println("Introduce un nombre de alumno valido: ");
					String nombre = teclado.nextLine();
					estudiante.LeerXnombre(nombre);
					break;
			default: break;
							}
			}while (opcionleer != 0);
		System.out.println("Salimos del menu de lectura de Alumnos.");
	}
	
	public static void LecturaProfesores() {
		GestionProfesores maestro = new GestionProfesores();
		Scanner teclado = new Scanner(System.in);
		int opcionleer = 0;
		do {
			System.out.println("MENU LECTURA PROFESOR.\n");
			System.out.println("1.  Mostrar todos los Profesores.");
			System.out.println("2.  Mostrar Profesor buscando por su identificador.");
			System.out.println("0.  SALIR.\n");
			System.out.print("Eloja opción del 0 al 2:  ");
			
			opcionleer = teclado.nextInt();
			String a = teclado.nextLine();
			
			switch(opcionleer) {
			case 1: maestro.LeerTodo();
					break;
			case 2: System.out.println("Introduce un identificador de profesor valido: ");
					int idprofesor = teclado.nextInt();
					String b = teclado.nextLine();
					maestro.LeerXid(idprofesor);
					break;
			default: break;
							}
			}while (opcionleer != 0);
		System.out.println("Salimos del menu de lectura de Pofesores.");
	}
	
	public static void LecturaModulos() {
		GestionModulos asignatura = new GestionModulos();
		Scanner teclado = new Scanner(System.in);
		int opcionleer = 0;
		do {
			System.out.println("MENU LECTURA MODULOS.\n");
			System.out.println("1.  Mostrar todos los Modulos.");
			System.out.println("2.  Mostrar Modulo buscando por su identificador.");
			System.out.println("0.  SALIR.\n");
			System.out.print("Eloja opción del 0 al 2:  ");
			
			opcionleer = teclado.nextInt();
			String a = teclado.nextLine();
			
			switch(opcionleer) {
			case 1: asignatura.LeerTodo();
					break;
			case 2: System.out.println("Introduce un identificador de modulo valido: ");
					int idmodulo = teclado.nextInt();
					String b = teclado.nextLine();
					asignatura.LeerXid(idmodulo);
					break;
			default: break;
							}
			}while (opcionleer != 0);
		System.out.println("Salimos del menu de lectura de Modulo.");
	}

	public static void InsertarAlumno() {
		GestionAlumnos estudiante = new GestionAlumnos();
		Scanner teclado = new Scanner(System.in);
		System.out.println("\n INSERTAMOS NUEVO ALUMNO.\n");
		System.out.println("Introduce nombre del Alumno: ");
		String nombre = teclado.nextLine();
		System.out.println("\nIntroduce email del alumno: ");
		String email = teclado.nextLine();
		estudiante.InsertarAlumno(nombre, email);
	}

	public static void InsertarProfesor() {
		Scanner teclado = new Scanner(System.in);
		GestionProfesores maestro = new GestionProfesores();
		System.out.println("\n INSERTAMOS NUEVO PROFESOR.\n");
		System.out.println("Introduce nombre del Profesor: ");
		String nombremaestro = teclado.nextLine();
		System.out.println("\nIntroduce email del Profesor: ");
		String emailmaestro = teclado.nextLine();
		System.out.println("\nIndtroduce DNI del Profesor: ");
		String dnimaestro = teclado.nextLine();
		maestro.InsertarProfesor(nombremaestro, dnimaestro, emailmaestro);
	}
	
	public static void InsertarModulo() {
		Scanner teclado = new Scanner(System.in);
		GestionModulos asignatura = new GestionModulos();
		System.out.println("\n INSERTAMOS NUEVO MODULO.\n");
		System.out.println("Introduce nombre del Modulo: ");
		String nombremodulo = teclado.nextLine();
		System.out.println("\nIntroduce identificador del Profesor: ");
		int idprofesor = teclado.nextInt();
		String a = teclado.nextLine();
		asignatura.InsertarModulo(idprofesor, nombremodulo);
	}
	
	public static void BorrarAlumno() {
		GestionAlumnos estudiante = new GestionAlumnos();
		Scanner teclado = new Scanner(System.in);
		System.out.println("\n BORRAR ALUMNO.\n");
		System.out.println("Introduce identificador valido del Alumno: ");
		int idalumno = teclado.nextInt();
		String a = teclado.nextLine();
		estudiante.BorrarAlumno(idalumno);
	}
	
	public static void BorrarProfesor() { 
		Scanner teclado = new Scanner(System.in);
		GestionProfesores maestro = new GestionProfesores();
		System.out.println("\n BORRAR PROFESOR.\n");
		System.out.println("Introduce identificador valido del Profesor: ");
		int idprofesor = teclado.nextInt();
		String a = teclado.nextLine();
		maestro.BorrarProfesor(idprofesor);
	}
	
	public static void BorrarModulo() {
		Scanner teclado = new Scanner(System.in);
		GestionModulos asignatura = new GestionModulos();
		System.out.println("\n BORRAR MODULO.\n");
		System.out.println("Introduce identificador valido de Modulo: ");
		int idmodulo = teclado.nextInt();
		String a = teclado.nextLine();
		asignatura.BorrarModulo(idmodulo);
	}
	
	public static void InsertarModuloAlumno() {
		Scanner teclado = new Scanner(System.in);
		GestionAlumnos estudiante = new GestionAlumnos();
		System.out.println("\nINSERTAR UN MODULO A UN ALUMNO.\n");
		System.out.println("Introduce un identificador valido de Alumno: ");
		int idalumno = teclado.nextInt();
		String a = teclado.nextLine();
		System.out.println("\nIntroduce un identificador valido de Modulo: ");
		int idmodulo = teclado.nextInt();
		a=teclado.nextLine();
		estudiante.InsertarModulo(idalumno, idmodulo);
	}
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int opcion = 0;
		do {
			System.out.println("MENU DE OPCIONES PARA LA BD instituto.\n");
			System.out.println("1.  Lectura de la tabla Alumnos.");
			System.out.println("2.  Lectura de la tabla Profesor.");
			System.out.println("3.  Lectura de la tabla Modulo.\n");
			System.out.println("4.  Insertar Alumno nuevo.");
			System.out.println("5.  Insertar Profesor nuevo.");
			System.out.println("6.  Insertar Modulo nuevo.\n");
			System.out.println("7.  Borrar Alumno.");
			System.out.println("8.  Borrar Profesor.");
			System.out.println("9.  Borrar Modulo.\n");
			System.out.println("10. Insertar Alumno en Modulo.\n\n");
			System.out.println("0.  SALIR.\n");
			System.out.print("Eliga opción del 0 al 10: ");
			opcion = teclado.nextInt();
			String a = teclado.nextLine();
			
			switch(opcion){
				case 1:	LecturaAlumnos();
						break;
				case 2: LecturaProfesores();
						break;
				case 3: LecturaModulos();
						break;
				case 4: InsertarAlumno();
						break;
				case 5: InsertarProfesor();
						break;
				case 6: InsertarModulo();
						break;
				case 7: BorrarAlumno();
						break;
				case 8: BorrarProfesor();
						break;
				case 9: BorrarModulo();
						break;
				case 10: InsertarModuloAlumno();
						 break;
				default:break;
			}
			
			
		 }while(opcion != 0);
		
		System.out.println("Salimos de la aplicación........");
		
	}

}
