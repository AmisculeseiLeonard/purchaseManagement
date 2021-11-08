package ooad.purchasemanagement.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ooad.purchasemanagement.model.Invoice;

@Transactional
@Repository("invoice")
public class InvoiceDao implements Dao<Invoice>{
	
	@Autowired
	private EntityManager entityManager;

	
	@Override
	public List<Invoice> getAll() {
		Session session = entityManager.unwrap(Session.class);
		
		List<Invoice> invoices = session.createQuery("from Invoice", Invoice.class).getResultList();
		
		return invoices;
	}
	
	@Override
	public Optional<Invoice> get(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Optional<Invoice> invoice = Optional.ofNullable(session
				.createQuery("Select e from Invoice e where e.id = '" + id + "'", Invoice.class)
				.getSingleResult());
		
		return invoice;
	}

	@Override
	public void save(Invoice t) {
		Session session = entityManager.unwrap(Session.class);
		session.save(t);
		
		
	}

	@Override
	public void delete(Invoice t) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(t);
		
	}

	@Override
	public Invoice update(Invoice t) {
		Session session = entityManager.unwrap(Session.class);
		Invoice  invoice = (Invoice) session.merge(t);
		return invoice;
		
	}

}
