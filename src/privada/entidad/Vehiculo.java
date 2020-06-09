package privada.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@NamedQuery(name = "recuperarVehiculos", query = "SELECT u FROM Vehiculo u WHERE u.cliente = :cliente")
@NamedQuery(name = "recuperarPorPlaca", query = "SELECT u FROM Vehiculo u WHERE u.placa = :placa")
/**
 * Entity implementation class for Entity: Vehiculo
 *
 */
@Entity

public class Vehiculo implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private String placa;
	private String marca;
	private String modelo;
	@ManyToOne
	@JoinColumn
	private Cliente cliente;
	@OneToMany(cascade= CascadeType.ALL,mappedBy = "vehiculo",orphanRemoval=true)
	List<Ticket> tickets;
	public Vehiculo() {
		tickets = new ArrayList<Ticket>();
		
	}
	public Vehiculo(String placa, String marca, String modelo, Cliente cliente, List<Ticket> tickets) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.cliente = cliente;
		this.tickets = tickets;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
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
		Vehiculo other = (Vehiculo) obj;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vehiculo [placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", cliente=" + cliente
				+ ", tickets=" + tickets + "]";
	}
	
	
	
	
	
	
	
   
}
