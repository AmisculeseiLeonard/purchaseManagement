package ooad.purchasemanagement.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ooad.purchasemanagement.model.AbstractContractState;


@Transactional
@Repository("contract_state")
public class ContractStateDao implements Dao<AbstractContractState>{
	
	@Autowired
	private EntityManager entityManager;

	
	@Override
	public List<AbstractContractState> getAll() {
		Session session = entityManager.unwrap(Session.class);
		
		List<AbstractContractState> contractStates = session.createQuery("from ContractState", AbstractContractState.class).getResultList();
		
		return contractStates;
	}
	
	@Override
	public Optional<AbstractContractState> get(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Optional<AbstractContractState> contractState = Optional.ofNullable(session
				.createQuery("Select e from ContractState e where e.id = '" + id + "'", AbstractContractState.class)
				.getSingleResult());
		
		return contractState;
	}

	@Override
	public void save(AbstractContractState t) {
		Session session = entityManager.unwrap(Session.class);
		session.save(t);
		
		
	}

	@Override
	public void delete(AbstractContractState t) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(t);
		
	}

	@Override
	public AbstractContractState update(AbstractContractState t) {
		Session session = entityManager.unwrap(Session.class);
		AbstractContractState  contractState = (AbstractContractState) session.merge(t);
		return contractState;
		
	}

}
