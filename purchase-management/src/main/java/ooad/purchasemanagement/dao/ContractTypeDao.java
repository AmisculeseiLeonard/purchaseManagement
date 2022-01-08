package ooad.purchasemanagement.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ooad.purchasemanagement.model.AbstractContractType;

@Transactional
@Repository("contract_type")
public class ContractTypeDao implements Dao<AbstractContractType>{
	
	@Autowired
	private EntityManager entityManager;

	
	@Override
	public List<AbstractContractType> getAll() {
		Session session = entityManager.unwrap(Session.class);
		
		List<AbstractContractType> contractTypes = session.createQuery("from ContractType", AbstractContractType.class).getResultList();
		
		return contractTypes;
	}
	
	@Override
	public Optional<AbstractContractType> get(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Optional<AbstractContractType> contractType = Optional.ofNullable(session
				.createQuery("Select e from ContractType e where e.id = '" + id + "'", AbstractContractType.class)
				.getSingleResult());
		
		return contractType;
	}

	@Override
	public void save(AbstractContractType t) {
		Session session = entityManager.unwrap(Session.class);
		session.save(t);
		
		
	}

	@Override
	public void delete(AbstractContractType t) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(t);
		
	}

	@Override
	public AbstractContractType update(AbstractContractType t) {
		Session session = entityManager.unwrap(Session.class);
		AbstractContractType  contractType = (AbstractContractType) session.merge(t);
		return contractType;
		
	}

}
