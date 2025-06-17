package com.task.users.mapper;

import org.springframework.stereotype.Component;

import com.task.users.dto.UserDTO;
import com.task.users.model.Address;
import com.task.users.model.Bank;
import com.task.users.model.Company;
import com.task.users.model.Coordinates;
import com.task.users.model.Crypto;
import com.task.users.model.Hair;
import com.task.users.model.User;

@Component
public class UserMapper {
	public User toEntity(UserDTO dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setMaidenName(dto.getMaidenName());
		user.setAge(dto.getAge());
		user.setGender(dto.getGender());
		user.setEmail(dto.getEmail());
		user.setPhone(dto.getPhone());
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setBirthDate(dto.getBirthDate());
		user.setImage(dto.getImage());
		user.setBloodGroup(dto.getBloodGroup());
		user.setHeight(dto.getHeight());
		user.setWeight(dto.getWeight());
		user.setEyeColor(dto.getEyeColor());

		// Map hair
		if (dto.getHair() != null) {
			user.setHair(new Hair(dto.getHair().getColor(), dto.getHair().getType()));
		}

		user.setIp(dto.getIp());

		// Map address
		if (dto.getAddress() != null) {
			Address address = new Address();
			address.setAddress(dto.getAddress().getAddress());
			address.setCity(dto.getAddress().getCity());
			address.setState(dto.getAddress().getState());
			address.setStateCode(dto.getAddress().getStateCode());
			address.setPostalCode(dto.getAddress().getPostalCode());

			if (dto.getAddress().getCoordinates() != null) {
				address.setCoordinates(new Coordinates(dto.getAddress().getCoordinates().getLat(),
						dto.getAddress().getCoordinates().getLng()));
			}

			address.setCountry(dto.getAddress().getCountry());
			user.setAddress(address);
		}

		user.setMacAddress(dto.getMacAddress());
		user.setUniversity(dto.getUniversity());

		// Map bank
		if (dto.getBank() != null) {
			user.setBank(new Bank(dto.getBank().getCardExpire(), dto.getBank().getCardNumber(),
					dto.getBank().getCardType(), dto.getBank().getCurrency(), dto.getBank().getIban()));
		}

		// Map company
		if (dto.getCompany() != null) {
			Company company = new Company();
			company.setDepartment(dto.getCompany().getDepartment());
			company.setName(dto.getCompany().getName());
			company.setTitle(dto.getCompany().getTitle());

			if (dto.getCompany().getAddress() != null) {
				Address companyAddress = new Address();
				companyAddress.setAddress(dto.getCompany().getAddress().getAddress());
				companyAddress.setCity(dto.getCompany().getAddress().getCity());
				companyAddress.setState(dto.getCompany().getAddress().getState());
				companyAddress.setStateCode(dto.getCompany().getAddress().getStateCode());
				companyAddress.setPostalCode(dto.getCompany().getAddress().getPostalCode());

				if (dto.getCompany().getAddress().getCoordinates() != null) {
					companyAddress
							.setCoordinates(new Coordinates(dto.getCompany().getAddress().getCoordinates().getLat(),
									dto.getCompany().getAddress().getCoordinates().getLng()));
				}

				companyAddress.setCountry(dto.getCompany().getAddress().getCountry());
				company.setAddress(companyAddress);
			}

			user.setCompany(company);
		}

		user.setEin(dto.getEin());
		user.setSsn(dto.getSsn());
		user.setUserAgent(dto.getUserAgent());

		// Map crypto
		if (dto.getCrypto() != null) {
			user.setCrypto(
					new Crypto(dto.getCrypto().getCoin(), dto.getCrypto().getWallet(), dto.getCrypto().getNetwork()));
		}

		user.setRole(dto.getRole());

		return user;
	}
}
