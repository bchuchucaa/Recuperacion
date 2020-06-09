package privada.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import privada.dao.GenericDAO;

public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID>{

	private Class<T> persistentClass;
	protected EntityManager em;
	
	public JPAGenericDAO(Class<T> persistentClass) {
		this.persistentClass= persistentClass;
		this.em= Persistence.createEntityManagerFactory("jpa").createEntityManager();
	}
	
	@Override
	public void create(T entity) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
			System.out.println("La entidad se ah creado correctamente! ");
		}catch (Exception e) {
			System.out.println(">>>ERROR: JPAGenericDAO: create "+ e);
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
		
		
	}

	@Override
	public T read(ID id) {
		
		return em.find(persistentClass, id);
		
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.getTransaction().commit();
		try {
			
		}catch (Exception e) {
			 System.out.println(">>>> ERROR:JPAGenericDAO:update " + e);
			    if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
		
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		try {
			em.remove(entity);
		}catch (Exception e) {
			System.out.println(">>>> ERROR:JPAGenericDAO:delete "+ e);
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
		
	}

	@Override
	public void deletyById(ID id) {
		T entity= this.read(id);
		System.out.println("================");
		System.out.println("id="+ id);
		System.out.println(entity.toString());
		if(entity!=null)
			this.delete(entity);
		
		
	}

	@Override
	public List<T> find() {
		javax.persistence.criteria.CriteriaQuery cq= em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(persistentClass));
		return em.createQuery(cq).getResultList();
		
	}
	

}
