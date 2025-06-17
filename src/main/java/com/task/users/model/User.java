package com.task.users.model;

import java.time.LocalDate;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	@Id
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

	@Column(columnDefinition = "DATE")
//    @DateTimeFormat(pattern = "yyyy-M-d")
	private LocalDate birthDate;

	private String image;
	private String bloodGroup;
	private Double height;
	private Double weight;
	private String eyeColor;

	@Embedded
	private Hair hair;

	private String ip;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "address", column = @Column(name = "home_address")),
			@AttributeOverride(name = "city", column = @Column(name = "home_city")),
			@AttributeOverride(name = "state", column = @Column(name = "home_state")),
			@AttributeOverride(name = "stateCode", column = @Column(name = "home_state_code")),
			@AttributeOverride(name = "postalCode", column = @Column(name = "home_postal_code")),
			@AttributeOverride(name = "country", column = @Column(name = "home_country")),
			@AttributeOverride(name = "coordinates.lat", column = @Column(name = "home_lat")),
			@AttributeOverride(name = "coordinates.lng", column = @Column(name = "home_lng")) })
	private Address address;

	private String macAddress;
	private String university;

	@Embedded
	private Bank bank;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "address", column = @Column(name = "company_address")),
			@AttributeOverride(name = "city", column = @Column(name = "company_city")),
			@AttributeOverride(name = "state", column = @Column(name = "company_state")),
			@AttributeOverride(name = "stateCode", column = @Column(name = "company_state_code")),
			@AttributeOverride(name = "postalCode", column = @Column(name = "company_postal_code")),
			@AttributeOverride(name = "country", column = @Column(name = "company_country")),
			@AttributeOverride(name = "address.coordinates.lat", column = @Column(name = "company_lat")),
			@AttributeOverride(name = "address.coordinates.lng", column = @Column(name = "company_lng")) })
	private Company company;

	private String ein;
	private String ssn;
	private String userAgent;

	@Embedded
	private Crypto crypto;

	private String role;

}
