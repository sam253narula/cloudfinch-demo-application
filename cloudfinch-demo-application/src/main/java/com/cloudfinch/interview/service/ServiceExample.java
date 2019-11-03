package com.cloudfinch.interview.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cloudfinch.interview.dto.CountryDTO;

@Service
public class ServiceExample {
	// @Autowired
	// private RestTemplate restTemplate;

	List<CountryDTO> sortedcountryDTOs = new ArrayList<>();
	List<CountryDTO> furtherSortedcountryDTOs = new ArrayList<>();
	Map<String, List<CountryDTO>> mapOfCountriesSorted = new HashMap<String, List<CountryDTO>>();
	String region;

	public String helloUser() {
		return "Hello World";
	}

	/*
	 * PageDetails pageDetails = restTemplate .getForObject(PARAMETER_API_URL +
	 * pageId, PageDetails.class);
	 */

	public ResponseEntity<String> getCountries() {
		final String uri = "https://restcountries-v1.p.rapidapi.com/all";

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("x-rapidapi-host", "restcountries-v1.p.rapidapi.com");
		headers.add("x-rapidapi-key", "49fc55bb99msh6ab7ac1da739eabp170196jsn65e3bfb7489c");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		// String test = result.getBody().concat("name");
		// System.out.println("testing" + test);
		System.out.println(result);
		return result;
	}

	public List<CountryDTO> mapCountriestoDTO() {
		final String uri = "https://restcountries-v1.p.rapidapi.com/all";

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("x-rapidapi-host", "restcountries-v1.p.rapidapi.com");
		headers.add("x-rapidapi-key", "49fc55bb99msh6ab7ac1da739eabp170196jsn65e3bfb7489c");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<List<CountryDTO>> response = restTemplate.exchange(uri, HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<CountryDTO>>() {
				});
		List<CountryDTO> countryDTOs = response.getBody();
		return countryDTOs;

	}

	public List<CountryDTO> getmapCountriestoDTOFromMyLocalsAPI() {
		final String uri = "http://localhost:8081/haveFunCreatingOrganizations/getJsonFile";

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		// headers.add("x-rapidapi-host", "restcountries-v1.p.rapidapi.com");
		// headers.add("x-rapidapi-key",
		// "49fc55bb99msh6ab7ac1da739eabp170196jsn65e3bfb7489c");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<List<CountryDTO>> response = restTemplate.exchange(uri, HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<CountryDTO>>() {
				});
		List<CountryDTO> countryDTOs = response.getBody();
		return countryDTOs;

	}

	public Stream<Object> getRequiredData() {
		Map<String, List<CountryDTO>> mapOfCountries = getmapCountriestoDTOFromMyLocalsAPI().stream()
				.collect(Collectors.groupingBy(country -> country.getRegion()));

		return mapOfCountries.entrySet().stream().map(entry -> {
			entry.setValue(entry.getValue().stream().sorted((e1, e2) -> Integer.compare(e2.getArea(), e1.getArea()))
					.limit(5).collect(Collectors.toList()));
			return entry;
		});
	}
}
