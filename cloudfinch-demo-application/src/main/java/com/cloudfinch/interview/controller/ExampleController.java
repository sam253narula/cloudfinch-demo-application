package com.cloudfinch.interview.controller;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudfinch.interview.dto.CountryDTO;
import com.cloudfinch.interview.dto.ListOfCountries;
import com.cloudfinch.interview.service.ServiceExample;

@RestController
@RequestMapping("/home")
public class ExampleController {
	
	@Autowired
	ServiceExample serviceExample;
	@GetMapping("/test")
	public String Test() {
		return serviceExample.helloUser();
	}
	
	@GetMapping("/countries")
	public ResponseEntity<String> getCountries() {
		return serviceExample.getCountries();
	}
	
	@GetMapping("/mapCountriesToDTO")
	public List<CountryDTO> mapCountriestoDTO() {
		return serviceExample.mapCountriestoDTO();
	}
	
	@GetMapping("/requireddata")
	public Stream<Object> requireddata(){
		return serviceExample.getRequiredData();
	}
	
	@GetMapping("/FetchingFromLocalAPI")
	public List<CountryDTO> fromLocalAPI(){
		return serviceExample.getmapCountriestoDTOFromMyLocalsAPI();
	}
	
}
