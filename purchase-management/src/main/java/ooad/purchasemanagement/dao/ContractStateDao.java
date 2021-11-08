package ooad.purchasemanagement.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ooad.purchasemanagement.model.ContractState;


@Transactional
@Repository("contract_state")
public class ContractStateDao implements Dao<ContractState>{
	
	@Autowired
	private EntityManager entityManager;

	
	@Override
	public List<ContractState> getAll() {
		Session session = entityManager.unwrap(Session.class);
		
		List<ContractState> contractStates = session.createQuery("from ContractState", ContractState.class).getResultList();
		
		return contractStates;
	}
	
	@Override
	public Optional<ContractState> get(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Optional<ContractState> contractState = Optional.ofNullable(session
				.createQuery("Select e from ContractState e where e.id = '" + id + "'", ContractState.class)
				.getSingleResult());
		
		return contractState;
	}

	@Override
	public void save(ContractState t) {
		Session session = entityManager.unwrap(Session.class);
		session.save(t);
		
		
	}

	@Override
	public void delete(ContractState t) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(t);
		
	}

	@Override
	public ContractState update(ContractState t) {
		Session session = entityManager.unwrap(Session.class);
		ContractState  contractState = (ContractState) session.merge(t);
		return contractState;
		
	}

}
