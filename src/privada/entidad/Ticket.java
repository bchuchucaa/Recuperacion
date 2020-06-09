package privada.entidad;

import java.io.Serializable;
import javax.persistence.*;

import com.sun.jmx.snmp.Timestamp;

@NamedQuery(name = "recuperarTickets", query = "SELECT u FROM Ticket u WHERE u.vehiculo = :vehiculo")
/**
 * Entity implementation class for Entity: Ticket
 *
 */
@Entity

public class Ticket implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;
	private String fechahoraingreso;
	private String fechahorasalida;
	@ManyToOne
	@JoinColumn
	private Vehiculo vehiculo;
	public Ticket() {
		super();
	}
	
	public Ticket(int numero, String fechahoraingreso, String fechahorasalida, Vehiculo vehiculo) {
		super();
		this.numero = numero;
		this.fechahoraingreso = fechahoraingreso;
		this.fechahorasalida = fechahorasalida;
		this.vehiculo = vehiculo;
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getFechahoraingreso() {
		return fechahoraingreso;
	}
	public void setFechahoraingreso(String fechahoraingreso) {
		this.fechahoraingreso = fechahoraingreso;
	}
	public String getFechahorasalida() {
		return fechahorasalida;
	}
	public void setFechahorasalida(String fechahorasalida) {
		this.fechahorasalida = fechahorasalida;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
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
		Ticket other = (Ticket) obj;
		if (numero != other.numero)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Ticket [numero=" + numero + ", fechahoraingreso=" + fechahoraingreso + ", fechahorasalida="
				+ fechahorasalida + ", vehiculo=" + vehiculo + "]";
	}
	
   
	
}
