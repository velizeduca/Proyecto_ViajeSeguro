package com.viajes.dao;

import java.util.List;
import com.viajes.entidad.Bus;


public interface IBusDAO {
	
	void registrar(Bus b);
	void actualizar(Bus b);
	Bus buscar(int id);
	List<Bus>listar();
	void eliminarLogico(int id);

}
