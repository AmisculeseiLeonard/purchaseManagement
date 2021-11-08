package ooad.purchasemanagement.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ooad.purchasemanagement.model.ContractType;

@Transactional
@Repository("contract_type")
public class ContractTypeDao implements Dao<ContractType>{
	
	@Autowired
	private EntityManager entityManager;

	
	@Override
	public List<ContractType> getAll() {
		Session session = entityManager.unwrap(Session.class);
		
		List<ContractType> contractTypes = session.createQuery("from ContractType", ContractType.class).getResultList();
		
		return contractTypes;
	}
	
	@Override
	public Optional<ContractType> get(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Optional<ContractType> contractType = Optional.ofNullable(session
				.createQuery("Select e from ContractType e where e.id = '" + id + "'", ContractType.class)
				.getSingleResult());
		
		return contractType;
	}

	@Override
	public void save(ContractType t) {
		Session session = entityManager.unwrap(Session.class);
		session.save(t);
		
		
	}

	@Override
	public void delete(ContractType t) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(t);
		
	}

	@Override
	public ContractType update(ContractType t) {
		Session session = entityManager.unwrap(Session.class);
		ContractType  contractType = (ContractType) session.merge(t);
		return contractType;
		
	}

}
