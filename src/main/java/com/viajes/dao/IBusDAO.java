package com.viajes.dao;

import java.util.List;
import com.viajes.entidad.Bus;


public interface IBusDAO {
	
	void registrarBus(Bus b);
	void actualizarBus(Bus b);
	Bus buscarBus(int id);
	List<Bus>listarBus();
	void eliminarLogicoBus(int id);

}
