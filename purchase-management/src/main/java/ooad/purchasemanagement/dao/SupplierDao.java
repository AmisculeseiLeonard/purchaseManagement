package ooad.purchasemanagement.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ooad.purchasemanagement.model.Supplier;

@Transactional
@Repository("supplier")
public class SupplierDao implements Dao<Supplier>{
	
	@Autowired
	private EntityManager entityManager;

	
	@Override
	public List<Supplier> getAll() {
		Session session = entityManager.unwrap(Session.class);
		
		List<Supplier> suppliers = session.createQuery("from Supplier", Supplier.class).getResultList();
		
		return suppliers;
	}
	
	@Override
	public Optional<Supplier> get(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Optional<Supplier> supplier = Optional.ofNullable(session
				.createQuery("Select s from Supplier s where s.id = '" + id + "'", Supplier.class)
				.getSingleResult());
		
		return supplier;
	}

	@Override
	public void save(Supplier t) {
		Session session = entityManager.unwrap(Session.class);
		session.save(t);
		
		
	}

	@Override
	public void delete(Supplier t) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(t);
		
	}

	@Override
	public Supplier update(Supplier t) {
		Session session = entityManager.unwrap(Session.class);
		Supplier supplier = (Supplier) session.merge(t);
		return supplier;
		
	}
}
