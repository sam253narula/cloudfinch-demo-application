package com.cloudfinch.interview.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown=true)
public class ListOfCountries implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	List<CountryDTO> countryDTOs;
}
