package privada.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import privada.dao.VehiculoDAO;
import privada.entidad.Cliente;

import privada.entidad.Vehiculo;

public class JPAVehiculoDAO extends JPAGenericDAO<Vehiculo, String> implements VehiculoDAO{

	public JPAVehiculoDAO() {
		super(Vehiculo.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Vehiculo> recuperarVehiculos(Vehiculo entity) {
		// TODO Auto-generated method stub
		Cliente cliente=entity.getCliente();
		Query query = em.createNamedQuery("recuperarVehiculos");
		query.setParameter("cliente",cliente);
		@SuppressWarnings("unchecked")
		List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		vehiculos=query.getResultList();
		System.out.println("METODO RECUPERAR vehiculos "+vehiculos.toString());
		return vehiculos;
	}

	@Override
	public Vehiculo recuperarPorPlaca(Vehiculo entity) {
		String placa = entity.getPlaca();
		Query query = em.createNamedQuery("recuperarPorPlaca");
		query.setParameter("placa",placa);
		@SuppressWarnings("unchecked")
		Vehiculo ve= (Vehiculo) query.getSingleResult();
		System.out.println(ve.toString());
		return ve;
	}

}
