package ooad.purchasemanagement.dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ooad.purchasemanagement.model.Agent;

@Transactional
@Repository("agent")
public class AgentDao implements Dao<Agent>{
	
	@Autowired
	private EntityManager entityManager;

	
	@Override
	public List<Agent> getAll() {
		Session session = entityManager.unwrap(Session.class);
		
		List<Agent> agents = session.createQuery("from Agent", Agent.class).getResultList();
		
		return agents;
	}
	
	@Override
	public Optional<Agent> get(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Optional<Agent> agent = Optional.ofNullable(session
				.createQuery("Select e from Agent e where e.id = '" + id + "'", Agent.class)
				.getSingleResult());
		
		return agent;
	}

	@Override
	public void save(Agent t) {
		Session session = entityManager.unwrap(Session.class);
		session.save(t);
		
		
	}

	@Override
	public void delete(Agent t) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(t);
		
	}

	@Override
	public Agent update(Agent t) {
		Session session = entityManager.unwrap(Session.class);
		Agent  agent = (Agent) session.merge(t);
		return agent;
		
	}

	

}
