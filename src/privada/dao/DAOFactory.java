package privada.dao;

import privada.jpa.JPADAOFactory;

public abstract class DAOFactory {

	protected static DAOFactory factory= new JPADAOFactory();
	
	public static DAOFactory getFactory() {
		
		return factory;
	}
	
	
	public abstract ClienteDAO getClienteDAO();
	
	public abstract VehiculoDAO getVehiculoDAO();
	
	public abstract TicketDAO getTicketDAO();
	
	
}
