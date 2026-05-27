package com.viajes.dao;

import java.util.List;
import com.viajes.entidad.Bus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BusDAO implements IBusDAO{

	EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("UP");//conectandose con el archivo persistence.xml
	EntityManager em=fabrica.createEntityManager();//contiene los metodos necesarios para hacer el crud
	 			
	
	
	@Override
	public  void registrarBus(Bus b) {
		try {
			em.getTransaction().begin();
			em.persist(b);
			em.getTransaction().commit();
			System.out.println("bus registrado");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actualizarBus(Bus b) {
		try {
			em.getTransaction().begin();
			em.merge(b);
			em.getTransaction().commit();
			System.out.println("bus actualizado");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Bus buscarBus(int id) {
		Bus b=null;
		try {
			b=em.find(Bus.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<Bus> listarBus() {
	
		List<Bus>lista=null;
		try {
			String jpql="SELECT b FROM Bus b";
			lista=em.createQuery(jpql,Bus.class).getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return lista;
	}

	@Override
	public void eliminarLogicoBus(int id) {
	 try {
		 em.getTransaction().begin();
		 Bus b=em.find(Bus.class, id);
		 
		 //validar el objeto b
		 if(b!=null) {
			 b.setNomEstado("INACTIVO");
			 em.merge(b);
			 em.getTransaction().commit();
			 System.out.println("bus desactivado");
		 }else {
			 System.out.println("bus no encontrado");
		 }
		
		 
	} catch (Exception e) {
		e.printStackTrace();
	}	
	}

}
