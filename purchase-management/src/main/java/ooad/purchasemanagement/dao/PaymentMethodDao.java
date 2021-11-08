package ooad.purchasemanagement.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ooad.purchasemanagement.model.PaymentMethod;

@Transactional
@Repository("payment_method")
public class PaymentMethodDao implements Dao<PaymentMethod>{
	
	@Autowired
	private EntityManager entityManager;

	
	@Override
	public List<PaymentMethod> getAll() {
		Session session = entityManager.unwrap(Session.class);
		
		List<PaymentMethod> paymentMethods = session.createQuery("from PaymentMethod", PaymentMethod.class).getResultList();
		
		return paymentMethods;
	}
	
	@Override
	public Optional<PaymentMethod> get(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Optional<PaymentMethod> paymentMethods = Optional.ofNullable(session
				.createQuery("Select e from PaymentMethod e where e.id = '" + id + "'", PaymentMethod.class)
				.getSingleResult());
		
		return paymentMethods;
	}

	@Override
	public void save(PaymentMethod t) {
		Session session = entityManager.unwrap(Session.class);
		session.save(t);
		
		
	}

	@Override
	public void delete(PaymentMethod t) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(t);
		
	}

	@Override
	public PaymentMethod update(PaymentMethod t) {
		Session session = entityManager.unwrap(Session.class);
		PaymentMethod  paymentMethods = (PaymentMethod) session.merge(t);
		return paymentMethods;
		
	}

}
