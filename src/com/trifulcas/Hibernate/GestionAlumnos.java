package com.trifulcas.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.trifulcas.Hibernate.entity.Alumnos;
import com.trifulcas.Hibernate.entity.Modulos;
import com.trifulcas.Hibernate.entity.Profesores;



import java.util.List;
import java.util.ArrayList;

public class GestionAlumnos {

	//Constructor.
	public void GestionAlumnos() {}
	
	//Metodos lectura de alumnos.
	public void LeerXnombre (String nombre) {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Alumnos.class).addAnnotatedClass(Modulos.class).addAnnotatedClass(Profesores.class);
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
								.addAnnotatedClass(Alumnos.class).addAnnotatedClass(Modulos.class).addAnnotatedClass(Profesores.class);
				
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
						.addAnnotatedClass(Alumnos.class).addAnnotatedClass(Modulos.class).addAnnotatedClass(Profesores.class);
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
	
	//Metodo Insert nuevo alumno.
	
	public void InsertarAlumno(String nombre, String email) {
		// Crear la configuración cogíendola del xml y añadiendo la clase Categorias
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Alumnos.class).addAnnotatedClass(Modulos.class).addAnnotatedClass(Profesores.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
										.applySettings(configuration.getProperties());
						
		// Crear la factoría de sesiones
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
						
		// Crear la sesión
		Session session = factory.getCurrentSession();

		try {
			System.out.println("Inicio de Insert de un alumno en la tabla Alumnos (se le pasa los datos de nombre y email).");

			// Iniciar transacción
			session.beginTransaction();

			Alumnos alu = new Alumnos(nombre, email);
			session.save(alu);
								
			// commit de la transacción
			session.getTransaction().commit();

			} finally {
						factory.close();
					}
	}
	
	//Metodo Delete alumno.
	public void BorrarAlumno(int id) {
		// Crear la configuración cogíendola del xml y añadiendo la clase Alumnos
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Alumnos.class).addAnnotatedClass(Modulos.class).addAnnotatedClass(Profesores.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
								.applySettings(configuration.getProperties());
				
		// Crear la factoría de sesiones
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
				
		// Crear la sesión
		Session session = factory.getCurrentSession();

		try {
			System.out.println("Borrar un alumno de la tabla Alumnos.  Seleccionamos el registro según el valor de idalumno: " + id);

			// Iniciar transacción
			session.beginTransaction();
						
			// Leemos un alumno
			@SuppressWarnings("unchecked")
			List<Alumnos> ListaAlum = session.createQuery("from Alumnos where idalumno = " + id).getResultList();
			if (ListaAlum.size() != 0) 
				{
					//Borrar un alumno.
					Alumnos cat= session.get(Alumnos.class, id);
					session.delete(cat);
				} else {
						System.out.println("La tabla Alumno no contiene ningun registro con el idalumno " + id);
					   }
						
			// commit de la transacción
			session.getTransaction().commit();

			} finally {
						factory.close();
					 }
		}
	
	//Metodo Insert modulo a un alumno
	public void InsertarModulo(int idalumno, int idmodulo) {
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Modulos.class).addAnnotatedClass(Profesores.class).addAnnotatedClass(Alumnos.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());

		// Crear la factoría de sesiones
		SessionFactory factory = configuration.buildSessionFactory(builder.build());

		// Crear la sesión
		Session session = factory.getCurrentSession();

		try {
			System.out.println("Verificando que exista el modulo " + idmodulo);
			// Iniciar transacción
			session.beginTransaction();
			Modulos modulo=session.get(Modulos.class, idmodulo);


			if (modulo==null) {
			System.out.println("No existe el módulo");
			session.close();
			return;
			}
			Alumnos alumno=session.get(Alumnos.class, idalumno);
			if (alumno==null) {
			System.out.println("No existe el alumno");
			session.close();
			return;
			}

			alumno.addModulo(modulo);
			session.save(alumno);
			session.save(modulo);
			session.getTransaction().commit();

				
				
		}  finally {
					factory.close();
				   }
		
		
	}

	//Metodo Delete modulo a un alumno
	public void DeleteModulo(int idalumno, int idmodulo) {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Modulos.class).addAnnotatedClass(Profesores.class).addAnnotatedClass(Alumnos.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());

		// Crear la factoría de sesiones
		SessionFactory factory = configuration.buildSessionFactory(builder.build());

		// Crear la sesión
		Session session = factory.getCurrentSession();

		try {
			System.out.println("Verificando que exista el modulo " + idmodulo);
			// Iniciar transacción
			session.beginTransaction();
			Modulos modulo=session.get(Modulos.class, idmodulo);


			if (modulo==null) {
								System.out.println("No existe el módulo " + idmodulo);
								session.close();
								return;
							  }
			
			System.out.println("Verificando que exista el alumno " + idalumno);
			Alumnos alumno=session.get(Alumnos.class, idalumno);
			if (alumno==null) {
								System.out.println("No existe el alumno " + idalumno);
								session.close();
								return;
							  }
			//session.delete(alumno);
			session.delete(modulo);
			
			// commit de la transacción
			session.getTransaction().commit();
			
			}  finally {
			factory.close();
		   }
	}
}
