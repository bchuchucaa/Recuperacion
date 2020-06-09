package privada.dao;

import java.util.List;


import privada.entidad.Vehiculo;

public interface VehiculoDAO extends GenericDAO<Vehiculo,String>  {

	
	public List<Vehiculo> recuperarVehiculos(Vehiculo entity);
	public Vehiculo recuperarPorPlaca(Vehiculo entity);
	
}
