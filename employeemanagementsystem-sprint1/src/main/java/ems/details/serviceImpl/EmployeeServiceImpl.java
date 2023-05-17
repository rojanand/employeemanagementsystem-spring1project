package ems.details.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ems.details.Repositories.EmployeeRepository;
import ems.details.dto.EmployeeDto;
import ems.details.entity.Employee;
import ems.details.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(EmployeeDto employeeDto) {
		Employee employee=Employee.builder().name(employeeDto.getName()).age(employeeDto.getAge()).email(employeeDto.getEmail()).desgination(employeeDto.getDesgination()).address(employeeDto.getAddress()).mobileNo(employeeDto.getMobileNo()).build();
		return employeeRepository.save(employee);
	}

	@Override
	public Employee findEmployee(long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public String updateEmployee(EmployeeDto employeeDto, long id) {
		Employee employee=employeeRepository.findById(id).get();
		employee.setName(employeeDto.getName());
		employee.setAge(employeeDto.getAge());
		employee.setEmail(employeeDto.getEmail());
		employee.setDesgination(employeeDto.getDesgination());
		employee.setAddress(employeeDto.getAddress());
		employee.setMobileNo(employeeDto.getMobileNo());
		employeeRepository.save(employee);
		return "employee records updated successfully";
	}

	@Override
	public String deleteEmployee(long id) {
		employeeRepository.deleteById(id);
		return "The Employee with id "+id+" has been deleted successfully";
	}

	@Override
	public List<Employee> callAllEmployee() {
		
		return employeeRepository.findAll();
	}

}
