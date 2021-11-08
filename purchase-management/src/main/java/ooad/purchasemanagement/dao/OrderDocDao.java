package ooad.purchasemanagement.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ooad.purchasemanagement.model.OrderDoc;

@Transactional
@Repository("order")
public class OrderDocDao implements Dao<OrderDoc>{
	
	@Autowired
	private EntityManager entityManager;

	
	@Override
	public List<OrderDoc> getAll() {
		Session session = entityManager.unwrap(Session.class);
		
		List<OrderDoc> orders = session.createQuery("from OrderDoc", OrderDoc.class).getResultList();
		
		return orders;
	}
	
	@Override
	public Optional<OrderDoc> get(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Optional<OrderDoc> order = Optional.ofNullable(session
				.createQuery("Select e from OrderDoc e where e.id = '" + id + "'", OrderDoc.class)
				.getSingleResult());
		
		return order;
	}

	@Override
	public void save(OrderDoc t) {
		Session session = entityManager.unwrap(Session.class);
		session.save(t);
		
		
	}

	@Override
	public void delete(OrderDoc t) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(t);
		
	}

	@Override
	public OrderDoc update(OrderDoc t) {
		Session session = entityManager.unwrap(Session.class);
		OrderDoc  order = (OrderDoc) session.merge(t);
		return order;
		
	}

}
