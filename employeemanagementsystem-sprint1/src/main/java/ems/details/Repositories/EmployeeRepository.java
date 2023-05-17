package ems.details.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ems.details.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
