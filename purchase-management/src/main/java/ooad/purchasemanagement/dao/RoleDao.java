package ooad.purchasemanagement.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ooad.purchasemanagement.model.Role;

@Transactional
@Repository("role")
public class RoleDao implements Dao<Role>{
	
	@Autowired
	private EntityManager entityManager;

	
	@Override
	public List<Role> getAll() {
		Session session = entityManager.unwrap(Session.class);
		
		List<Role> roles = session.createQuery("from Role", Role.class).getResultList();
		
		return roles;
	}
	
	@Override
	public Optional<Role> get(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Optional<Role> role = Optional.ofNullable(session
				.createQuery("Select r from Role r where r.id = '" + id + "'", Role.class)
				.getSingleResult());
		
		return role;
	}

	@Override
	public void save(Role t) {
		Session session = entityManager.unwrap(Session.class);
		session.save(t);
		
		
	}

	@Override
	public void delete(Role t) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(t);
		
	}

	@Override
	public Role update(Role t) {
		Session session = entityManager.unwrap(Session.class);
		Role  employee = (Role) session.merge(t);
		return employee;
		
	}

}
