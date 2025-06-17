package com.task.users.model;

import java.time.LocalDate;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
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

	public User() {
	}

	public User(Long id, String firstName, String lastName, String maidenName, Integer age, String gender, String email,
			String phone, String username, String password, LocalDate birthDate, String image, String bloodGroup,
			Double height, Double weight, String eyeColor, Hair hair, String ip, Address address, String macAddress,
			String university, Bank bank, Company company, String ein, String ssn, String userAgent, Crypto crypto,
			String role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.maidenName = maidenName;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.birthDate = birthDate;
		this.image = image;
		this.bloodGroup = bloodGroup;
		this.height = height;
		this.weight = weight;
		this.eyeColor = eyeColor;
		this.hair = hair;
		this.ip = ip;
		this.address = address;
		this.macAddress = macAddress;
		this.university = university;
		this.bank = bank;
		this.company = company;
		this.ein = ein;
		this.ssn = ssn;
		this.userAgent = userAgent;
		this.crypto = crypto;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMaidenName() {
		return maidenName;
	}

	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public Hair getHair() {
		return hair;
	}

	public void setHair(Hair hair) {
		this.hair = hair;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getEin() {
		return ein;
	}

	public void setEin(String ein) {
		this.ein = ein;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public Crypto getCrypto() {
		return crypto;
	}

	public void setCrypto(Crypto crypto) {
		this.crypto = crypto;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
