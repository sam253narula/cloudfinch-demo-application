package com.cloudfinch.interview.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author samarth narula
 *
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MockDTO {
	private String name;
	private int age;
	private int salary;
	private String project;
	
}