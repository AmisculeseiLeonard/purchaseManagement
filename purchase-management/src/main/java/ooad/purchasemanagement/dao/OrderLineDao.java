package ooad.purchasemanagement.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ooad.purchasemanagement.model.OrderLine;

@Transactional
@Repository("orderLine")
public class OrderLineDao implements Dao<OrderLine>{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public Optional<OrderLine> get(int id) {
		Session session = entityManager.unwrap(Session.class);
		Optional<OrderLine> orderLine =  Optional.ofNullable(session
				.createQuery("Select l from OrderLine l where l.id = '" + id + "'" , OrderLine.class)
				.getSingleResult());
		return orderLine;
		
	}

	@Override
	public List<OrderLine> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<OrderLine> orderLines = session.createQuery("from OrderLine", OrderLine.class).getResultList();
		
		return orderLines;
	}

	@Override
	public void save(OrderLine t) {
		Session session = entityManager.unwrap(Session.class);
		session.save(t);
	}

	@Override
	public OrderLine update(OrderLine t) {
		Session session = entityManager.unwrap(Session.class);
		OrderLine orderLine =  (OrderLine) session.merge(t);
		return orderLine;
	}

	@Override
	public void delete(OrderLine t) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(t);
		
	}

}
