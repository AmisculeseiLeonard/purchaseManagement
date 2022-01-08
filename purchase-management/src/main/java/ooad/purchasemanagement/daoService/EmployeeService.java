package ooad.purchasemanagement.daoService;

import java.util.List;
import java.util.Optional;

import ooad.purchasemanagement.model.Employee;

public interface EmployeeService {
	
	 List<Employee> getAll();
	 
	 Optional<Employee> get(int id);
	 
	 void save(Employee t);
	 
	 void delete(Employee t);
	 
	 Employee update(Employee t);

}
