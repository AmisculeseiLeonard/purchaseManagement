package ooad.purchasemanagement.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ooad.purchasemanagement.model.Product;

@Transactional
@Repository("product")
public class ProductDao implements Dao<Product>{
	
	@Autowired
	private EntityManager entityManager;

	
	@Override
	public List<Product> getAll() {
		Session session = entityManager.unwrap(Session.class);
		
		List<Product> products = session.createQuery("from Product", Product.class).getResultList();
		
		return products;
	}
	
	@Override
	public Optional<Product> get(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Optional<Product> product = Optional.ofNullable(session
				.createQuery("Select e from Product e where e.id = '" + id + "'", Product.class)
				.getSingleResult());
		
		return product;
	}

	@Override
	public void save(Product t) {
		Session session = entityManager.unwrap(Session.class);
		session.save(t);
		
		
	}

	@Override
	public void delete(Product t) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(t);
		
	}

	@Override
	public Product update(Product t) {
		Session session = entityManager.unwrap(Session.class);
		Product  product = (Product) session.merge(t);
		return product;
		
	}
}
