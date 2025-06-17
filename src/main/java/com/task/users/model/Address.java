package com.task.users.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Address {
	private String address;
	private String city;
	private String state;
	private String stateCode;
	private String postalCode;

	@Embedded
	private Coordinates coordinates;

	private String country;

}