package privada.dao;

import java.util.List;

import privada.entidad.Ticket;
import privada.entidad.Vehiculo;

public interface TicketDAO extends GenericDAO<Ticket,Integer> {

	
	public List<Ticket> recuperarTickets(Ticket entity);
}
