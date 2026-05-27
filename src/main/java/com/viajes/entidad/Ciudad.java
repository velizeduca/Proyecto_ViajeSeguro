package com.viajes.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table (name="tb_ciudad")

public class Ciudad {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_ciudad")
private int idCiudad;

@Column (name = "nombre")
private String nomCiudad;

@Column(name = "estado")
private String estado;



public Ciudad() {
	super();
}



public int getIdCiudad() {
	return idCiudad;
}



public void setIdCiudad(int idCiudad) {
	this.idCiudad = idCiudad;
}







public String getNomCiudad() {
	return nomCiudad;
}



public void setNomCiudad(String nomCiudad) {
	this.nomCiudad = nomCiudad;
}



public String getEstado() {
	return estado;
}



public void setEstado(String estado) {
	this.estado = estado;
}






	
}
