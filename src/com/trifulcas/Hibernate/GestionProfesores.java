package com.trifulcas.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

import com.trifulcas.Hibernate.entity.Alumnos;
import com.trifulcas.Hibernate.entity.Modulos;
import com.trifulcas.Hibernate.entity.Profesores;

public class GestionProfesores {
	//Constructor.
		public GestionProfesores() { }
		
		//Metodos lectura de profesores
		public void LeerTodo() {
			// Crear la configuraci�n cog�endola del xml y a�adiendo la clase Categorias
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(Profesores.class).addAnnotatedClass(Modulos.class).addAnnotatedClass(Alumnos.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
									.applySettings(configuration.getProperties());
					
			// Crear la factor�a de sesiones
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
					
			// Crear la sesi�n
			Session session = factory.getCurrentSession();

			try {
				System.out.println("Inicio de lectura tabla Profesores (lectura total");

				// Iniciar transacci�n
				session.beginTransaction();

				@SuppressWarnings("unchecked")
				List<Profesores> ListaProfe = session.createQuery("from Profesores").getResultList();
				if (ListaProfe.size() != 0) {
					for(Profesores c: ListaProfe) {
								System.out.println(c.getIdprofesor() + " / " + c.getDni() + " / "+ c.getNombre() + " / " + c.getEmail());
										      	}
					} else { 
						System.out.println("La tabla Profesores no contiene ningun dato.");
					   		}
					
				// commit de la transacci�n
				session.getTransaction().commit();

			} finally {
					factory.close();
				  	}
		}
		
		public void LeerXid (int id) {
		// Crear la configuraci�n cog�endola del xml y a�adiendo la clase Categorias
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Profesores.class).addAnnotatedClass(Modulos.class).addAnnotatedClass(Alumnos.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
							.applySettings(configuration.getProperties());
			
		// Crear la factor�a de sesiones
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
			
		// Crear la sesi�n
		Session session = factory.getCurrentSession();

		try {
			System.out.println("Inicio de lectura de profesores por idprofesor.");

			// Iniciar transacci�n
			session.beginTransaction();

			// Leemos un profesor
			List<Profesores> ListaProfe = session.createQuery("from Profesores where idprofesor = " + id).getResultList();
					
			if (ListaProfe.size() != 0) {
					for(Profesores c: ListaProfe) {
								System.out.println(c.getIdprofesor() + " / " + c.getDni() + " / "+ c.getNombre() + " / " + c.getEmail());
							}
				} else { 
						System.out.println("La tabla Profesores no contiene ningun registro con el idprofesor proporcionado.");
						}
						
			// commit de la transacci�n
			session.getTransaction().commit();

			} finally {
						factory.close();
					  }
		}
		
		//Metodo para insertar un profesor en la tabla profesores.
		public void InsertarProfesor(String nombre, String dni, String email) {
			// Crear la configuraci�n cog�endola del xml y a�adiendo la clase Categorias
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(Profesores.class).addAnnotatedClass(Modulos.class).addAnnotatedClass(Alumnos.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
									.applySettings(configuration.getProperties());
					
			// Crear la factor�a de sesiones
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
					
			// Crear la sesi�n
			Session session = factory.getCurrentSession();

			try {
				System.out.println("Inicio de Insert de un profesor en la tabla Profesores (se le pasa los datos de nombre, dni y email)..");

				// Iniciar transacci�n
				session.beginTransaction();

				Profesores cat = new Profesores(nombre, dni, email);
				session.save(cat);
							
				// commit de la transacci�n
				session.getTransaction().commit();

				} finally {
							factory.close();
						  }
		}
		
		//Metodos para borrar profesores
		public void BorrarProfesor(int id) {
			// Crear la configuraci�n cog�endola del xml y a�adiendo la clase Alumnos
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(Profesores.class).addAnnotatedClass(Modulos.class).addAnnotatedClass(Alumnos.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
							.applySettings(configuration.getProperties());
			
			// Crear la factor�a de sesiones
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
			
			// Crear la sesi�n
			Session session = factory.getCurrentSession();

			try {
				System.out.println("Borrar un profesor de la tabla Profesores.  Seleccionamos el registro seg�n el valor de idprofesor: " + id);

					// Iniciar transacci�n
					session.beginTransaction();
					
					// Leemos un profesor
					@SuppressWarnings("unchecked")
					List<Profesores> ListaProfe = session.createQuery("from Profesores where idprofesor = " + id).getResultList();
					if (ListaProfe.size() != 0) 
						{
							//Borrar un profesor.
							Profesores cat= session.get(Profesores.class, id);
							session.delete(cat);
						} else {
							System.out.println("La tabla Profesores no contiene ningun registro con el idprofesor " + id);
								}
					
					// commit de la transacci�n
					session.getTransaction().commit();

				} finally {
							factory.close();
						  }
		}	
		
}
