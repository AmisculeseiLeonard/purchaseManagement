package ooad.purchasemanagement.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ooad.purchasemanagement.model.Contract;


@Transactional
@Repository("contract")
public class ContractDao implements Dao<Contract>{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Contract> getAll() {
		Session session = entityManager.unwrap(Session.class);
		
		List<Contract> employees = session.createQuery("from Contract", Contract.class).getResultList();
		
		return employees;
	}
	
	@Override
	public Optional<Contract> get(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Optional<Contract> employee = Optional.ofNullable(session
				.createQuery("Select e from Contract e where e.id = '" + id + "'", Contract.class)
				.getSingleResult());
		
		return employee;
	}

	@Override
	public void save(Contract t) {
		Session session = entityManager.unwrap(Session.class);
		session.save(t);
		
		
	}

	@Override
	public void delete(Contract t) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(t);
		
	}

	@Override
	public Contract update(Contract t) {
		Session session = entityManager.unwrap(Session.class);
		Contract  employee = (Contract) session.merge(t);
		return employee;
		
	}

}
