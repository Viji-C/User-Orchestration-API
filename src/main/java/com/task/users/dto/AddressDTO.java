package com.task.users.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO {
	private String address;
	private String city;
	private String state;
	private String stateCode;
	private String postalCode;
	private CoordinatesDTO coordinates;
	private String country;

}