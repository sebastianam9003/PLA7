package com.trifulcas.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

import com.trifulcas.Hibernate.entity.Alumnos;
import com.trifulcas.Hibernate.entity.Modulos;
import com.trifulcas.Hibernate.entity.Profesores;

public class GestionModulos {
	//Constructor.
	public GestionModulos() { }
		
	//Metodos de lectura de la tabla modulos.
	public void LeerTodo() {
		// Crear la configuración cogíendola del xml y añadiendo la clase Categorias
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(Modulos.class).addAnnotatedClass(Profesores.class).addAnnotatedClass(Alumnos.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
									.applySettings(configuration.getProperties());
					
		// Crear la factoría de sesiones
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
					
		// Crear la sesión
		Session session = factory.getCurrentSession();

		try {
			System.out.println("Inicio de lectura.");

			// Iniciar transacción
			session.beginTransaction();

			@SuppressWarnings("unchecked")
			List<Modulos> ListaModu = session.createQuery("from Modulos").getResultList();
			if (ListaModu.size() != 0) {
					for(Modulos c: ListaModu) {
								System.out.println(c.getIdmodulo() + " / " + c.getProfesor().getIdprofesor() + " / "+ c.getNombre());
									}
				} else {
						System.out.println("La tabla Modulos no contiene ningun dato.");
						}
					
			// commit de la transacción
			session.getTransaction().commit();

			} finally {
							factory.close();
						}
		}
		
	public void LeerXid (int id) {
		// Crear la configuración cogíendola del xml y añadiendo la clase Categorias
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(Modulos.class).addAnnotatedClass(Profesores.class).addAnnotatedClass(Alumnos.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
							.applySettings(configuration.getProperties());
			
		// Crear la factoría de sesiones
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
			
		// Crear la sesión
		Session session = factory.getCurrentSession();

		try {
			System.out.println("Inicio de lectura.");

			// Iniciar transacción
			session.beginTransaction();

			// Leemos un modulo.
			@SuppressWarnings("unchecked")
			List<Modulos> ListaModu = session.createQuery("from Modulos where idmodulo = " + id).getResultList();
			if (ListaModu.size() != 0) {
				for(Modulos c: ListaModu) {
								System.out.println(c.getIdmodulo() + " / " + c.getProfesor().getIdprofesor() + " / "+ c.getNombre());
							}
				} else {
						System.out.println("La tabla Modulos no contiene ningun registro con el idmodulo proporcionado.");
						}
						
						
			// commit de la transacción
			session.getTransaction().commit();

			} finally {
						factory.close();
						  }
		}

	//Metodos para insertar un registro en la tabla modulos
	public void InsertarModulo(int idprofesor, String nombre) {
		// Crear la configuración cogíendola del xml y añadiendo la clase Profesores
		Configuration configuration1 = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Profesores.class).addAnnotatedClass(Modulos.class).addAnnotatedClass(Alumnos.class);
		StandardServiceRegistryBuilder builder1 = new StandardServiceRegistryBuilder()
									.applySettings(configuration1.getProperties());
					
		// Crear la factoría de sesiones
		SessionFactory factory1 = configuration1.buildSessionFactory(builder1.build());
					
		// Crear la sesión
		Session session1 = factory1.getCurrentSession();

		try {
			// Iniciar transacción
			session1.beginTransaction();

			// Leemos si existe el profesor.
			@SuppressWarnings("unchecked")
			List<Profesores> ListaProfe = session1.createQuery("from Profesores where idprofesor = " + idprofesor).getResultList();
			
			// commit de la transacción
			session1.getTransaction().commit();
			if (ListaProfe.size() != 0)
				{
					Profesores maestro = ListaProfe.get(0);
					System.out.println("Existe el profesor: " + maestro);
					System.out.println("Ahora inserto en la tabla Modulos.");
					// Crear la configuración cogíendola del xml y añadiendo la clase Categorias
					Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
										.addAnnotatedClass(Modulos.class).addAnnotatedClass(Profesores.class).addAnnotatedClass(Alumnos.class);
					StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
										.applySettings(configuration.getProperties());
								
					// Crear la factoría de sesiones
					SessionFactory factory = configuration.buildSessionFactory(builder.build());
								
					// Crear la sesión
					Session session = factory.getCurrentSession();

					try {
							System.out.println("Inicio de Insert de un modulo en la tabla Modulos (se le pasa los datos idprofesor y nombre).");

							// Iniciar transacción
							session.beginTransaction();

							Modulos modu = new Modulos(maestro, nombre);
							session.save(modu);
										
							// commit de la transacción
							session.getTransaction().commit();

						} finally {
									factory.close();
									}
					} else {
										System.out.println("No se puede dar de alta el modulo.  No existe profesor con el identificador " + idprofesor);
									}

				} finally {
							factory1.close();
						}

			
		}

	//Metodos para borrar modulo en la tabla modulos.
	public void BorrarModulo(int id) {
	// Crear la configuración cogíendola del xml y añadiendo la clase Alumnos
	Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(Modulos.class).addAnnotatedClass(Profesores.class).addAnnotatedClass(Alumnos.class);
	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
							.applySettings(configuration.getProperties());
			
	// Crear la factoría de sesiones
	SessionFactory factory = configuration.buildSessionFactory(builder.build());
			
	// Crear la sesión
	Session session = factory.getCurrentSession();

	try {
		System.out.println("Borrar un modulo de la tabla Modulos.  Seleccionamos el registro según el valor de idmodulo: " + id);

		// Iniciar transacción
		session.beginTransaction();
					
		// Leemos un modulo
		@SuppressWarnings("unchecked")
		List<Modulos> ListaModul = session.createQuery("from Modulos where idmodulo = " + id).getResultList();
		if (ListaModul.size() != 0) 
			{
				//Borrar un Modulo
				Modulos cat= session.get(Modulos.class, id);
				session.delete(cat);
			} else {
					System.out.println("La tabla Modulos no contiene ningun registro con el idmodulo " + id);
					}
					
		// commit de la transacción
		session.getTransaction().commit();

		} finally {
					factory.close();
					}
	}

	
		
}
