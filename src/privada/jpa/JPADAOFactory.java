package privada.jpa;

import privada.dao.ClienteDAO;
import privada.dao.DAOFactory;

import privada.dao.TicketDAO;

import privada.dao.VehiculoDAO;

public class JPADAOFactory  extends DAOFactory{

	@Override
	public ClienteDAO getClienteDAO() {
		// TODO Auto-generated method stub
		return new JPAClienteDAO();
	}

	@Override
	public VehiculoDAO getVehiculoDAO() {
		// TODO Auto-generated method stub
		return new JPAVehiculoDAO();
	}

	@Override
	public TicketDAO getTicketDAO() {
		// TODO Auto-generated method stub
		return new JPATicketDAO();
	}



}
