package com.bbva.apx.dto;

import java.util.Objects;

public class UsersDTO {
	private int id;
	private String nombre;

	public UsersDTO(){

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UsersDTO usersDTO = (UsersDTO) o;
		return id == usersDTO.id && Objects.equals(nombre, usersDTO.nombre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public String toString() {
		return "UsersDTO{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				'}';
	}
}
