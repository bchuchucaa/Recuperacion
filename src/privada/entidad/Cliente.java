package privada.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@NamedQuery(name = "buscarPorId", query = "SELECT u FROM Cliente u WHERE u.cedula = :id")

/**
 * Entity implementation class for Entity: Cliente
 *
 */
@Entity

public class Cliente implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private String cedula;
	private String nombre;
	private String direccion;
	private String telefono;
	@OneToMany(cascade= CascadeType.ALL,mappedBy = "cliente",orphanRemoval=true)
	private List<Vehiculo> vehiculos;
	
	public Cliente() {
		vehiculos = new ArrayList<Vehiculo>();
	}
	
	
	public Cliente(String cedula, String nombre, String direccion, String telefono, List<Vehiculo> vehiculos) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.vehiculos = vehiculos; 
	}

	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public List<Vehiculo> getVechiculos() {
		return vehiculos;
	}
	public void setVechiculos(List<Vehiculo> vechiculos) {
		this.vehiculos = vechiculos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cliente [cedula=" + cedula + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono="
				+ telefono + ", vechiculos=" + vehiculos + "]";
	}
	
	
	

}
