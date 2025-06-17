package com.task.users.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankDTO {
	private String cardExpire;
	private String cardNumber;
	private String cardType;
	private String currency;
	private String iban;

}
