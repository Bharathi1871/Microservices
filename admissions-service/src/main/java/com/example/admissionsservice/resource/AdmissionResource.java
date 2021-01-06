package com.example.admissionsservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.admissionsservice.model.DiseasesList;
import com.example.admissionsservice.model.EmployeesList;
import com.example.admissionsservice.model.Patient;

@RestController
@RequestMapping("/admissions")
public class AdmissionResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${hr.service.url}")
	private String url;
	List<Patient> patients = Arrays.asList(
			new Patient("p1","Gabor","Hungarian"),
			new Patient("p2","Emeeka","Nigerian"),
			new Patient("p3","Emily","American")
			);
	
	@RequestMapping("/physicians")
	public EmployeesList getPhysicians() {
		System.out.print("Inside the admissions::::"+url);
		EmployeesList employeesList = 
				restTemplate.getForObject(url, EmployeesList.class);
		return employeesList;
	}
	@RequestMapping("/diseases")
	public DiseasesList getDiseases() {
		DiseasesList diseasesList = 
				restTemplate.getForObject("http://localhost:8084/pathology/diseases", DiseasesList.class);
		return diseasesList;
	}
	@RequestMapping("/patients")
	List<Patient> getPatiens(){
		return patients;
		
	}
	
	@RequestMapping("/patients/{Id}")
	public Patient getPatientById(@PathVariable("Id") String Id) {
		
		Patient p = patients.stream()
				.filter(patient -> Id.equals(patient.getId()))
				.findAny()
				.orElse(null);
		return p;
				
				
		
	}
}
