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
			b.setCapacidadPasajeros(75);
			b.setDescripEstado("Activo");	
			dao.registrarBus(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//metodo para listar los buses
	public static void listarBuses() {
		BusDAO dao=new BusDAO();
		List<Bus>listame=dao.listarBus();
		
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
            b.getCapacidadPasajeros(),
            b.getDescripEstado());
}
	
	}
	
	//metodo para actualizar el bus
	public static void actualizarDatosBus() {
		BusDAO dao=new BusDAO();
		//
		Bus b=dao.buscarBus(2);
		//asigna nueva marca
		MarcaBus mb=new MarcaBus();
		mb.setIdMarca(2);
		//setear los datos
		b.setMarcaB(mb);
		b.setDescripModelo("VOLVO 2027");
		b.setNroPlaca("VOL-555");
		b.setCapacidadPasajeros(80);
		b.setDescripEstado("ACTIVO");
		dao.actualizarBus(b);
		
	}
	
	//metodo para eliminar logicamante los datos del bus.
	
	public static void eliminarLogicamemteBus() {
		BusDAO dao=new BusDAO();
		dao.eliminarLogicoBus(4);
	}
	
	
	//metodo para buscar el codigo de bus
	public static void buscarBusXcodigo() {
		BusDAO dao=new BusDAO();
		Bus b=dao.buscarBus(2);
		
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
			            b.getCapacidadPasajeros(),
			            b.getDescripEstado());
		}else
		{
			System.out.println("Bus no encontrado");
		}
		
		
	}
	
	
	

}
