package ooad.purchasemanagement.daoService;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ooad.purchasemanagement.dao.EmployeeDao;
import ooad.purchasemanagement.model.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	private static volatile EmployeeServiceImpl obj  = null;

	private EmployeeServiceImpl() {}

	public static EmployeeServiceImpl getInstance()
	{
		if (obj == null)
		{
			synchronized (EmployeeServiceImpl.class)
			{
		
				if (obj==null)
					obj = new EmployeeServiceImpl();
			}
		}
		return obj;
	}

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	@Override
	public Optional<Employee> get(int id) {
		return employeeDao.get(id);
	}

	@Override
	public void save(Employee t) {
		employeeDao.save(t);

	}

	@Override
	public void delete(Employee t) {
		employeeDao.delete(t);

	}

	@Override
	public Employee update(Employee t) {
		return employeeDao.update(t);
	}

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

}
