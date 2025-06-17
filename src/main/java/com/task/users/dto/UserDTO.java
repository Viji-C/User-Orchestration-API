package com.task.users.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.task.users.utils.FlexibleDateDeserializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private String maidenName;
	private Integer age;
	private String gender;
	private String email;
	private String phone;
	private String username;
	private String password;
	@JsonDeserialize(using = FlexibleDateDeserializer.class)
	private LocalDate birthDate;
	private String image;
	private String bloodGroup;
	private Double height;
	private Double weight;
	private String eyeColor;
	private HairDTO hair;
	private String ip;
	private AddressDTO address;
	private String macAddress;
	private String university;
	private BankDTO bank;
	private CompanyDTO company;
	private String ein;
	private String ssn;
	private String userAgent;
	private CryptoDTO crypto;
	private String role;

}
