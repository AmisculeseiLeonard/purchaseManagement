package ooad.purchasemanagement.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ooad.purchasemanagement.model.Employee;

@Transactional
@Repository("employee")
public class EmployeeDao implements Dao<Employee> {
	
	@Autowired
	private EntityManager entityManager;

	
	@Override
	public List<Employee> getAll() {
		Session session = entityManager.unwrap(Session.class);
		
		List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();
		
		return employees;
	}
	
	@Override
	public Optional<Employee> get(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Optional<Employee> employee = Optional.ofNullable(session
				.createQuery("Select e from Employee e where e.id = '" + id + "'", Employee.class)
				.getSingleResult());
		
		return employee;
	}

	@Override
	public void save(Employee t) {
		Session session = entityManager.unwrap(Session.class);
		session.save(t);
		
		
	}

	@Override
	public void delete(Employee t) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(t);
		
	}

	@Override
	public Employee update(Employee t) {
		Session session = entityManager.unwrap(Session.class);
		Employee  employee = (Employee) session.merge(t);
		return employee;
		
	}

	

}
