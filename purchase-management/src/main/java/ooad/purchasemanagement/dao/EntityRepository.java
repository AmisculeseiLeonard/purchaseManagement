package ooad.purchasemanagement.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ooad.purchasemanagement.model.Contract;
import ooad.purchasemanagement.model.Employee;
import ooad.purchasemanagement.model.Invoice;

@Transactional
@Repository("employee2")
public class EntityRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Employee> getAllEmployees() {
		Session session = entityManager.unwrap(Session.class);
		
		List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();
		
		return employees;
	}
	
	public Optional<Employee> getEmployee(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Optional<Employee> employee = Optional.ofNullable(session
				.createQuery("Select e from Employee e where e.id = '" + id + "'", Employee.class)
				.getSingleResult());
		
		return employee;
	}

	
	public void saveEmployee(Employee t) {
		Session session = entityManager.unwrap(Session.class);
		session.save(t);
	}

	
	public void deleteEmployee(Employee t) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(t);
	}

	
	public Employee updateEmployee(Employee t) {
		Session session = entityManager.unwrap(Session.class);
		Employee  employee = (Employee) session.merge(t);
		return employee;
		
	}
	
	public List<Contract> getAllContracts() {
		Session session = entityManager.unwrap(Session.class);
		
		List<Contract> employees = session.createQuery("from Contract", Contract.class).getResultList();
		
		return employees;
	}
	
	public Optional<Contract> getContract(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Optional<Contract> employee = Optional.ofNullable(session
				.createQuery("Select e from Contract e where e.id = '" + id + "'", Contract.class)
				.getSingleResult());
		
		return employee;
	}

	public void saveContract(Contract t) {
		Session session = entityManager.unwrap(Session.class);
		session.save(t);
	}

	public void deleteContract(Contract t) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(t);
		
	}

	public Contract updateContract(Contract t) {
		Session session = entityManager.unwrap(Session.class);
		Contract  employee = (Contract) session.merge(t);
		return employee;
		
	}
	
	public List<Invoice> getAllInvoices() {
		Session session = entityManager.unwrap(Session.class);
		
		List<Invoice> invoices = session.createQuery("from Invoice", Invoice.class).getResultList();
		
		return invoices;
	}
	
	public Optional<Invoice> getInvoice(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Optional<Invoice> invoice = Optional.ofNullable(session
				.createQuery("Select e from Invoice e where e.id = '" + id + "'", Invoice.class)
				.getSingleResult());
		
		return invoice;
	}

	public void saveInvoice(Invoice t) {
		Session session = entityManager.unwrap(Session.class);
		session.save(t);
	}

	public void deleteInvoice(Invoice t) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(t);
	}

	public Invoice updateInvoice(Invoice t) {
		Session session = entityManager.unwrap(Session.class);
		Invoice  invoice = (Invoice) session.merge(t);
		return invoice;
	}
	
	//Same for the rest of entities

}
