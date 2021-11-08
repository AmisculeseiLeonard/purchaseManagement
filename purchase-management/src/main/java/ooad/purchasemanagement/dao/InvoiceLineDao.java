package ooad.purchasemanagement.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ooad.purchasemanagement.model.InvoiceLine;

@Transactional
@Repository("invoice_line")
public class InvoiceLineDao implements Dao<InvoiceLine>{
	
	@Autowired
	private EntityManager entityManager;

	
	@Override
	public List<InvoiceLine> getAll() {
		Session session = entityManager.unwrap(Session.class);
		
		List<InvoiceLine> invoiceLines = session.createQuery("from InvoiceLine", InvoiceLine.class).getResultList();
		
		return invoiceLines;
	}
	
	@Override
	public Optional<InvoiceLine> get(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Optional<InvoiceLine> invoiceLine = Optional.ofNullable(session
				.createQuery("Select e from InvoiceLine e where e.id = '" + id + "'", InvoiceLine.class)
				.getSingleResult());
		
		return invoiceLine;
	}

	@Override
	public void save(InvoiceLine t) {
		Session session = entityManager.unwrap(Session.class);
		session.save(t);
		
		
	}

	@Override
	public void delete(InvoiceLine t) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(t);
		
	}

	@Override
	public InvoiceLine update(InvoiceLine t) {
		Session session = entityManager.unwrap(Session.class);
		InvoiceLine  invoiceLine = (InvoiceLine) session.merge(t);
		return invoiceLine;
		
	}

}
