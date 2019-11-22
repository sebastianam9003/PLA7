package com.trifulcas.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.trifulcas.Hibernate.entity.Alumnos;



import java.util.List;
import java.util.ArrayList;

public class GestionAlumnos {

	//Constructor.
	public void GestionAlumnos() {}
	
	//Metodos lectura de alumnos.
	public void LeerXnombre (String nombre) {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Alumnos.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties());
		
		// Crear la factoría de sesiones
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		// Crear la sesión
		Session session = factory.getCurrentSession();

		try {
			System.out.println("Inicio de lectura de la tabla Alumnos por nombre.  Valor introduccido: " + nombre);

				// Iniciar transacción
				session.beginTransaction();

				@SuppressWarnings("unchecked")
				List<Alumnos> ListaAlum = session.createQuery("from Alumnos where nombre like '%"+nombre+"%' ").getResultList();
				System.out.println(ListaAlum);
				for(Alumnos c: ListaAlum) {
					System.out.println(c);
					System.out.println(c.getIdalumno() + " / " + c.getNombre() + " / " + c.getEmail());
				}
		
				// commit de la transacción
				session.getTransaction().commit();

			} finally {
						factory.close();
					  }
	}
	
	public void LeerTodo() {
				Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Alumnos.class);
				
				StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
								.applySettings(configuration.getProperties());
				
				// Crear la factoría de sesiones
				SessionFactory factory = configuration.buildSessionFactory(builder.build());
				
				// Crear la sesión
				Session session = factory.getCurrentSession();

				try {
					System.out.println("Inicio de lectura de Alumnos (lectura total).");

						// Iniciar transacción
						session.beginTransaction();

						@SuppressWarnings("unchecked")
						List<Alumnos> ListaAlum = session.createQuery("from Alumnos").getResultList();
						if (ListaAlum.size() != 0) 
							{
								for(Alumnos c: ListaAlum) {
									System.out.println(c.getIdalumno() + " / " + c.getNombre() + " / " + c.getEmail());
														}
							} else {
								System.out.println("La tabla Alumnos no contiene ningun dato.");
							}
				
						// commit de la transacción
						session.getTransaction().commit();

					} finally {
								factory.close();
							  }
			}
	
	public void LeerXid (int id) {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Alumnos.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties());
		
		// Crear la factoría de sesiones
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		// Crear la sesión
		Session session = factory.getCurrentSession();

		try {
			System.out.println("Inicio de lectura de alumnos por idalumno.");

				// Iniciar transacción
				session.beginTransaction();

				// Leemos un alumno
				@SuppressWarnings("unchecked")
				List<Alumnos> ListaAlum = session.createQuery("from Alumnos where idalumno = " + id).getResultList();
				if (ListaAlum.size() != 0) 
					{
						for(Alumnos c: ListaAlum) {
							System.out.println(c.getIdalumno() + " / " + c.getNombre() + " / " + c.getEmail());
												}
					} else {
						System.out.println("La tabla Alumno no contiene ningun registro con el idalumno " + id);
					}
					
				// commit de la transacción
				session.getTransaction().commit();

			} finally {
						factory.close();
					  }
	}
	
	//Metodos Insert nuevo alumno.
	
}
