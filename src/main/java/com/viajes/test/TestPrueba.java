package com.viajes.test;

import jakarta.persistence.EntityManagerFactory;

import java.util.List;

import com.viajes.entidad.Ciudad;

import jakarta.persistence.EntityManager;

import jakarta.persistence.Persistence;

public class TestPrueba {
	
 static EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("UP");//conectandose con el archivo persistence.xml
 static EntityManager em=fabrica.createEntityManager();//contiene los metodos necesarios para hacer el crud
 	
	public static void main(String[] args) {

	//registrarCiudad();
	//buscarCiudadxCodigo(2);
	//actualizarCiudad();
	//eliminarCiudadLogicamente();
		listarCiudades();
		
	/*	
	//declarando un objeto EMF
		EntityManagerFactory fabrica=null;
	//declarando un objeto para em
		EntityManager em=null;
		
		try {
		  fabrica=Persistence.createEntityManagerFactory("UP");
		  em=fabrica.createEntityManager();  
		  System.out.println("conexion correcta con JPA y Hibernate");
		} catch (Exception e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}
		
		finally {
			if(em!=null)em.close();
			if(fabrica!=null)fabrica.close();
		}

*/
		
		
		
	}

	//metodo para registrar datos de la ciudad
	public static void registrarCiudad() {
	try {
		em.getTransaction().begin();
		//declarar un objeto de tipo Ciudad
		Ciudad c=new Ciudad();
		//setear
		c.setNomCiudad("Junin");
		c.setEstado("Activo");
		//guardar
		em.persist(c);// insert into
		//confirmar la transaccion
		em.getTransaction().commit();//confirma la transaccion
		System.out.println("ciudad registrado correctamente");
		
	} catch (Exception e) {
		System.out.println("error al registrar");
		e.printStackTrace();
	}	
		
	}
	
	
	//metodo para buscar Ciudad en base al codigo
	public static void buscarCiudadxCodigo(int codi) {
		try {
			Ciudad c=em.find(Ciudad.class, codi);
			//validamos al objeto c
			if(c!=null) {
				System.out.println("ID..:"+c.getIdCiudad());
				System.out.println("Nombre.:"+c.getNomCiudad());
				System.out.println("Estado..:"+c.getEstado());
			}
			else {
				System.out.println("cuidad no existe");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//metodo para actualizar la ciudad
	public static void actualizarCiudad() {
		try {
			em.getTransaction().begin();
			int codigo=1;
			Ciudad c=em.find(Ciudad.class, codigo);
			
			//validar el objeto c
			if(c!=null) {
				c.setNomCiudad("Lima Metropolitana");
				em.merge(c);//actualiza update
				em.getTransaction().commit();
				System.out.println("Ciudad actualizado correctamente");
			}
			else {
				System.out.println("ciudad no exuste");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//metodo para eliminar una ciudad logicamente
	public static void eliminarCiudadLogicamente() {
		try {
			em.getTransaction().begin();
			int codi=4;
			Ciudad c=em.find(Ciudad.class, codi);
			//validad al objeto c
			if(c!=null) {
				c.setEstado("INACTIVO");
				em.merge(c);
				em.getTransaction().commit();
				System.out.println("ciudad desctivada");
			}
			else {
				System.out.println("ciudad no existe..");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//metodo para listar las ciudades
	public static void listarCiudades() {
	  try {
		  //jpql
		  String jpql="SELECT c  FROM Ciudad c";
		  //declarar un objeto de lista
		  List<Ciudad>lista=em.createQuery(jpql,Ciudad.class).getResultList();
		  //hacer un recorrido
		  for(Ciudad c:lista) {
			  System.out.println("ID..:"+c.getIdCiudad());
			  System.out.println("Nombre..:"+c.getNomCiudad());
			  System.out.println("Estado..:"+c.getEstado());
			  System.out.println("---------------------------------");
		  }
		  
	} catch (Exception e) {
		e.printStackTrace();
	}	
		
		
	}
	
	
		
}
