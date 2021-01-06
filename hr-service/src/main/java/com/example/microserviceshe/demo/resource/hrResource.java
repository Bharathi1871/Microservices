package com.example.microserviceshe.demo.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.microserviceshe.demo.model.Employee;
import com.example.microserviceshe.demo.model.EmployeesList;

	

@RestController
@RequestMapping("/hr")
public class hrResource {
	List<Employee> employees = Arrays.asList(
			new Employee("E1","Bharathi","somana","ofss"),
			new Employee("E2","Santhosh","korimi","Finac"),
			new Employee("E3","sruthi","srinivas","oracle")
			);

	@RequestMapping("/employees")
	public EmployeesList getEmployees(){
		
		EmployeesList employeesList = new EmployeesList();
		employeesList.setEmployees(employees);
		return employeesList;
		
	}
	@RequestMapping("/employees/{Id}")
	public Employee getEmployeeById(@PathVariable("Id") String Id) {
		
		Employee e = employees.stream()
				.filter(employee -> Id.equals(employee.getId()))
				.findAny()
				.orElse(null);
		return e;
	}
				
}
