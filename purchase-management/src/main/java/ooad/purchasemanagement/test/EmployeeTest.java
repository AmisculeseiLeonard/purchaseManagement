package ooad.purchasemanagement.test;

import org.springframework.beans.factory.annotation.Autowired;

import ooad.purchasemanagement.dao.EmployeeDao;
import ooad.purchasemanagement.model.Employee;
import ooad.purchasemanagement.restController.EmployeeRestController;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee employee = 
				new Employee();
		
		employeeRestController.createEmployee(employee);
		
	}
	
	
	@Autowired
	public static EmployeeRestController employeeRestController;

}
