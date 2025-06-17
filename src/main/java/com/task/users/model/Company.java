package com.task.users.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class Company {
	private String department;
	private String name;
	private String title;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "address", column = @Column(name = "company_address")),
			@AttributeOverride(name = "city", column = @Column(name = "company_city")),
			@AttributeOverride(name = "state", column = @Column(name = "company_state")),
			@AttributeOverride(name = "stateCode", column = @Column(name = "company_state_code")),
			@AttributeOverride(name = "postalCode", column = @Column(name = "company_postal_code")),
			@AttributeOverride(name = "country", column = @Column(name = "company_country")) })
	private Address address;

	public Company() {
	}

	public Company(String department, String name, String title, Address address) {
		super();
		this.department = department;
		this.name = name;
		this.title = title;
		this.address = address;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
