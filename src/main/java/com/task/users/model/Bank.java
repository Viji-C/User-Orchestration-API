package com.task.users.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Bank {
	private String cardExpire;
	private String cardNumber;
	private String cardType;
	private String currency;
	private String iban;

}
