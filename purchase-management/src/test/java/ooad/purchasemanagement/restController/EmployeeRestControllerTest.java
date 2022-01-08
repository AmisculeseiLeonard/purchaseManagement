package ooad.purchasemanagement.restController;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ooad.purchasemanagement.dao.Dao;
import ooad.purchasemanagement.dao.EmployeeDao;
import ooad.purchasemanagement.model.Employee;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRestControllerTest {
	//https://thepracticaldeveloper.com/guide-spring-boot-controller-tests/
	 	@InjectMocks
	    EmployeeRestController employeeController;
	     
	 	@Autowired
		@Qualifier("employee")
		Dao<Employee> employeeDao;

	@Test
	void testGetAllEmployees() {
		fail("Not yet implemented");
	}

	@Test
	void testGetEmployeeById() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateEmployee() {
		 MockHttpServletRequest request = new MockHttpServletRequest();
	     RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	     
	     Employee employee =
					new Employee("Leonard", "Amisculesei", null, "ssds", "asdasd@gmail.com", null);
	     
	     employeeController.createEmployee(employee);
	}

	@Test
	void testUpdateEmployee() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteEmployee() {
		fail("Not yet implemented");
	}

}
