package privada.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import privada.dao.TicketDAO;
import privada.entidad.Cliente;
import privada.entidad.Ticket;
import privada.entidad.Vehiculo;

public class JPATicketDAO extends JPAGenericDAO<Ticket, Integer> implements TicketDAO{

	public JPATicketDAO() {
		super(Ticket.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Ticket> recuperarTickets(Ticket entity) {
		// TODO Auto-generated method stub
		Vehiculo vehiculo = entity.getVehiculo();
		Query query = em.createNamedQuery("recuperarTickets");
		query.setParameter("vehiculo",vehiculo);
		@SuppressWarnings("unchecked")
		List<Ticket> tickets = new ArrayList<Ticket>();
		tickets=query.getResultList();
		System.out.println("METODO RECUPERAR tickets "+tickets.toString());
		return tickets;
	}

}
