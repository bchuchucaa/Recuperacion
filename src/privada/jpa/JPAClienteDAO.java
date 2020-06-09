package privada.jpa;

import javax.persistence.Query;

import privada.dao.ClienteDAO;
import privada.entidad.Cliente;


public class JPAClienteDAO extends JPAGenericDAO<Cliente, String> implements ClienteDAO{

	public JPAClienteDAO() {
		super(Cliente.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Cliente buscarPorId(String id) {
		// TODO Auto-generated method stub
	
			Query query = em.createNamedQuery("buscarPorId");
			query.setParameter("id",id);
			@SuppressWarnings("unchecked")
			Cliente res= (Cliente) query.getSingleResult();
			return res;
		
		
	}

}
