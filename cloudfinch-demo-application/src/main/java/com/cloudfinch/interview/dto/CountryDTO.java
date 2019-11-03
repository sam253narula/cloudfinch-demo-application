package com.cloudfinch.interview.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonProperty("name")
	private String name;
	@JsonProperty("region")
	private String region;
	@JsonProperty("area")
	private int area;
}

/*
 * @JsonIgnoreProperties(ignoreUnknown=true) public class Entries {
 * 
 * @JsonProperty("EntryId") private String entryId;
 * 
 * @JsonProperty("Field1") private String field1;
 * 
 * @JsonProperty("Field2") private String field2;
 */