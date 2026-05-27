package com.viajes.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_bus")
public class Bus {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column (name = "id_bus")
private int idBus;
//relacion de muchos a uno....muchos buses pertenecen a una sola marca
@ManyToOne
//identificar la clave foranea
@JoinColumn(name = "id_marca_bus")
//vamos asumir que existe relacion entre MarcaBus y Bus, por lo tanto
private MarcaBus marcaB;

@Column (name = "modelo")
private String descripModelo;

@Column (name = "placa")
private String nroPlaca;

@Column(name = "capacidad")
private int capacidadPasajeros;

@Column(name = "estado")
private String descripEstado;



public Bus() {
	
}



public int getIdBus() {
	return idBus;
}



public void setIdBus(int idBus) {
	this.idBus = idBus;
}



public MarcaBus getMarcaB() {
	return marcaB;
}



public void setMarcaB(MarcaBus marcaB) {
	this.marcaB = marcaB;
}



public String getDescripModelo() {
	return descripModelo;
}



public void setDescripModelo(String descripModelo) {
	this.descripModelo = descripModelo;
}



public String getNroPlaca() {
	return nroPlaca;
}



public void setNroPlaca(String nroPlaca) {
	this.nroPlaca = nroPlaca;
}











public String getDescripEstado() {
	return descripEstado;
}



public void setDescripEstado(String descripEstado) {
	this.descripEstado = descripEstado;
}



public int getCapacidadPasajeros() {
	return capacidadPasajeros;
}



public void setCapacidadPasajeros(int capacidadPasajeros) {
	this.capacidadPasajeros = capacidadPasajeros;
}






	
	
	
}
