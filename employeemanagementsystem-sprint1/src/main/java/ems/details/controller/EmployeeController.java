package ems.details.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ems.details.dto.EmployeeDto;
import ems.details.entity.Employee;
import ems.details.exception.EmployeeNotFoundException;
import ems.details.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	//enter Details and save
	@PostMapping("/addemployee")
	public ResponseEntity<Employee> adEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
		try
		{
			Employee employee=employeeService.addEmployee(employeeDto);
			if(employee!=null)
			{
				return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
			}
		}
		catch(Exception e)
		{
			throw new EmployeeNotFoundException("Employee data is not inserted!!! Please enter vaild employee details...");
		}
		return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
	}
	
	//find employee by id
	@GetMapping("/findemployee/{id}")
	public ResponseEntity<Employee> fEmployee(@PathVariable("id") long id){
		try
		{
			Employee employee=employeeService.findEmployee(id);
			if(employee!=null)
			{
				return new ResponseEntity<Employee>(employee,HttpStatus.FOUND);
			}
		}
		catch(Exception e)
		{
			throw new EmployeeNotFoundException("Employee with id "+id+" is not found");
		}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	
	//update details by id
	@PutMapping("/update/{id}")
	public ResponseEntity<String> upEmployee(@PathVariable("id") long id, @RequestBody @Valid EmployeeDto employeeDto){
		try
		{
			String employee=employeeService.updateEmployee(employeeDto, id);
			if(employee!=null)
				return new ResponseEntity<String>(employee,HttpStatus.ACCEPTED);
		}
		catch(Exception e)
		{
			throw new EmployeeNotFoundException("Unable to update employee details");
		}
		return new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);
	}
	
	//delete details by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delEmployee(@PathVariable("id") long id){
		try
		{
			String employee=employeeService.deleteEmployee(id);
			if(employee!=null)
				return new ResponseEntity<String>(employee,HttpStatus.ACCEPTED);
		}
		catch (Exception e) {
			throw new EmployeeNotFoundException("Failed to delete employee details");
		}
		return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	//get all the employees details
	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		try
		{
			List<Employee> employee=employeeService.callAllEmployee();
			if(employee!=null)
				return new ResponseEntity<List<Employee>>(employee,HttpStatus.FOUND);
		}
		catch (Exception e) {
			throw new EmployeeNotFoundException("Failed to get all the employee details");
		}
		return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
	}

}
