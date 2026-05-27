package com.viajes.test;

import java.util.List;

import com.viajes.entidad.Bus;
import com.viajes.entidad.MarcaBus;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestPrueba2 {

	static EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("UP");//conectandose con el archivo persistence.xml
	static EntityManager em=fabrica.createEntityManager();//contiene los metodos necesarios para hacer el crud
	 		
	
	public static void main(String[] args) {
		
		//registrarBus();
	listarBuses();
		//buscarBusxCodigo(3);
		//actualizarBus();
		//eliminacionLogicaBus();
		

	}
	
	//metodo para registrar un Bus
	public static void registrarBus() {
	try {
		//iniciar la transaccion
		em.getTransaction().begin();
		//buscar una marca especifica
		int codMarca=2;
		//declarar un objeto de tipo MarcaBus
		MarcaBus mb=em.find(MarcaBus.class, codMarca);
		//declarar y crear un objeto de tipo Bus
		Bus b=new Bus();
		//setear
		b.setMarcaB(mb);
		b.setDescripModelo("KJ-4522026");
		b.setNroPlaca("YYY-251");
		b.setCapacidad(80);
		b.setNomEstado("ACTIVO");
		//GUARDAR
		em.persist(b);
		//confirmar la operacion o la transaccion
		em.getTransaction().commit();
		System.out.println("registrado correctamente");
				
	} catch (Exception e) {
		e.printStackTrace();
	}	

	
	}
	
	
	//metodo para listar los buses
	public static void listarBuses() {
		try {
			String jpql="SELECT b FROM Bus b";
			List<Bus>lista=em.createQuery(jpql,Bus.class).getResultList();
			//cabecera
	System.out.printf("%-5s %-15s %-15s %-12s %-12s %-10s\n",
							"ID",
							"MARCA",
							"MODELO",
							"NROPLACA",
							"CAPACIDAD",
							"ESTADO"
						);
   System.out.println("---------------------------------------------");
      //MOSTRAR EL DETALLE
   for(Bus b:lista) {
	   System.out.printf("%-5s %-15s %-15s %-12s %-12s %-10s\n",
			            b.getIdBus(),
			            b.getMarcaB().getNomMarca(),
			            b.getDescripModelo(),
			            b.getNroPlaca(),
			            b.getCapacidad(),
			            b.getNomEstado());
   }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//metodo para buscar Bus mediante el codigo
	public static void buscarBusxCodigo(int codigo) {
	try {
		Bus b=em.find(Bus.class, codigo);
		//validar el objeto b
		if(b!=null) {			
			System.out.printf("%-5s %-15s %-15s %-12s %-12s %-10s\n",
					"ID",
					"MARCA",
					"MODELO",
					"NROPLACA",
					"CAPACIDAD",
					"ESTADO"
				);
			System.out.println("---------------------------------------------");
		//detalle
			 System.out.printf("%-5s %-15s %-15s %-12s %-12s %-10s\n",
			            b.getIdBus(),
			            b.getMarcaB().getNomMarca(),
			            b.getDescripModelo(),
			            b.getNroPlaca(),
			            b.getCapacidad(),
			            b.getNomEstado());
		}else
		{
			System.out.println("Bus no encontrado");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	

		}
	
	//metodo para actualizar el bus
	public static void actualizarBus() {
		try {
			em.getTransaction().begin();
			int codigoBus=4;
			Bus b=em.find(Bus.class, codigoBus);
			//validando el objeto b
			if(b!=null) {
				//buscar el codigo de marca
				int codigoMarca=1;
				MarcaBus mb=em.find(MarcaBus.class, codigoMarca);
				//actualizar los datos
				b.setMarcaB(mb);
				b.setDescripModelo("Scania 2026");
				b.setNroPlaca("KJ-4522026");
				b.setCapacidad(70);
				b.setNomEstado("ACTIVO");
				//ACTUALIZAR
				em.merge(b);
				//confirmar la transaccion
				em.getTransaction().commit();
				System.out.println("actualizado correctamente");
			}else {
				System.out.println("error al actualizar");
			}
			//actualizar los datos
			//seteando
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//metodo para eliminar logicamente (cambiar el campo estado)
	public static void eliminacionLogicaBus() {
		try {
			em.getTransaction().begin();
			int codigoBus=4;
			Bus b=em.find(Bus.class, codigoBus);
			if(b!=null) {
				b.setNomEstado("INACTIVO");
				em.merge(b);
				em.getTransaction().commit();
				System.out.println("Bus desactivado");
			}
			else {
				System.out.println("No existe codigo de bus");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
