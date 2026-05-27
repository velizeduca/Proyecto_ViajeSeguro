package com.viajes.test;

import java.util.List;
import com.viajes.entidad.Bus;
import com.viajes.entidad.MarcaBus;
import com.viajes.dao.BusDAO;

public class TestPrueba3 {

	public static void main(String[] args) {
		
		//registrarBus();
//		listarBuses();
//		actualizarDatosBus();
		//eliminarLogicamemteBus();
		buscarBusXcodigo();
	}
	
	
//metodos para el crud
	public static void registrarBus() {
		try {
			//declarar y crear un objeto de tipo BusDAO
			BusDAO dao=new BusDAO();
			MarcaBus mb=new MarcaBus();
			Bus b=new Bus();
			//setear los datos
			mb.setIdMarca(1);
			b.setMarcaB(mb);
			b.setDescripModelo("SCANIA 2026");
			b.setNroPlaca("KKP-251");
			b.setCapacidad(75);
			b.setNomEstado("Activo");	
			dao.registrar(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//metodo para listar los buses
	public static void listarBuses() {
		BusDAO dao=new BusDAO();
		List<Bus>listame=dao.listar();
		
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
for(Bus b:listame) {
System.out.printf("%-5s %-15s %-15s %-12s %-12s %-10s\n",
            b.getIdBus(),
            b.getMarcaB().getNomMarca(),
            b.getDescripModelo(),
            b.getNroPlaca(),
            b.getCapacidad(),
            b.getNomEstado());
}
	
	}
	
	//metodo para actualizar el bus
	public static void actualizarDatosBus() {
		BusDAO dao=new BusDAO();
		//
		Bus b=dao.buscar(2);
		//asigna nueva marca
		MarcaBus mb=new MarcaBus();
		mb.setIdMarca(2);
		//setear los datos
		b.setMarcaB(mb);
		b.setDescripModelo("VOLVO 2027");
		b.setNroPlaca("VOL-555");
		b.setCapacidad(80);
		b.setNomEstado("ACTIVO");
		dao.actualizar(b);
		
	}
	
	//metodo para eliminar logicamante los datos del bus.
	
	public static void eliminarLogicamemteBus() {
		BusDAO dao=new BusDAO();
		dao.eliminarLogico(4);
	}
	
	
	//metodo para buscar el codigo de bus
	public static void buscarBusXcodigo() {
		BusDAO dao=new BusDAO();
		Bus b=dao.buscar(2);
		
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
		
		
	}
	
	
	

}
