package com.example.microservicesph.demo.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.microservicesph.demo.model.Disease;
import com.example.microservicesph.demo.model.DiseasesList;

@RestController
@RequestMapping("/pathology")
public class PathologyResource {

	List<Disease> diseases = Arrays.asList(
			new Disease("D1","Cancer","Medicine"),
			new Disease("D2","Fever","Injection"),
			new Disease("D3","Headache","Zandubom")
			);
	
	@RequestMapping("/diseases")
	public DiseasesList getDiseases(){
		
		DiseasesList diseasesList = new DiseasesList();
		diseasesList.setDisease(diseases);
		return diseasesList;
		
	}
	@RequestMapping("/diseases/{Id}")
	public Disease getDiseaseById(@PathVariable("Id") String Id) {
		
		Disease d = diseases.stream()
				.filter(diseases -> Id.equals(diseases.getId()))
				.findAny()
				.orElse(null);
		return d;
	}
}
