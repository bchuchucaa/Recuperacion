package privada.dao;

import privada.entidad.Cliente;


public interface ClienteDAO extends GenericDAO<Cliente,String> {

	public Cliente buscarPorId(String id);
}






