package com.viajes.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_marca_bus")

public class MarcaBus {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column (name = "id_marca_bus")
private int idMarca;
@Column(name = "nombre")
private String nomMarca;
@Column (name = "estado")
private String nomEstado;

public MarcaBus() {
	super();
}

public int getIdMarca() {
	return idMarca;
}

public void setIdMarca(int idMarca) {
	this.idMarca = idMarca;
}

public String getNomMarca() {
	return nomMarca;
}

public void setNomMarca(String nomMarca) {
	this.nomMarca = nomMarca;
}

public String getNomEstado() {
	return nomEstado;
}

public void setNomEstado(String nomEstado) {
	this.nomEstado = nomEstado;
}








	

}
