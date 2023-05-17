package ems.details.service;

import java.util.List;

import ems.details.dto.EmployeeDto;
import ems.details.entity.Employee;

public interface EmployeeService {
	
	Employee addEmployee(EmployeeDto employeeDto);
	Employee findEmployee(long id);
	String updateEmployee(EmployeeDto employeeDto, long id);
	String deleteEmployee(long id);
	List<Employee> callAllEmployee();

}
