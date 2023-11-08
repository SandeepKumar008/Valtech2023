package com.valtech.training.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.hibernate.Employee;
import com.valtech.training.spring.dao.EmployeeDAO;


@Service
@Transactional(propagation=Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public Employee createEmployee(Employee e) {
		return employeeDAO.saveEmployee(e);
	
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Employee makeActive(Employee e) {
		e.setActive(true);
		return employeeDAO.updatEmployee(e);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Employee makeInactive(Employee e) {
		e.setActive(false);
		return employeeDAO.updatEmployee(e);
	}
	
	@Override
	public Employee IncrementSalary(Employee e,float increment) {
		e.setSalary(e.getSalary()+increment);
		return employeeDAO.updatEmployee(e);
	}
	
	@Override
	public void incrementSalaryForAll(int increment) {
		employeeDAO.getAllEmployee().forEach(e -> e.setSalary(e.getSalary()+increment));
		
		
	}
	
	
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

}
