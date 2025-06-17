package com.task.users.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Crypto {
	private String coin;
	private String wallet;
	private String network;

	// Constructors, getters, setters
	public Crypto() {
	}

	public Crypto(String coin, String wallet, String network) {
		super();
		this.coin = coin;
		this.wallet = wallet;
		this.network = network;
	}

	public String getCoin() {
		return coin;
	}

	public void setCoin(String coin) {
		this.coin = coin;
	}

	public String getWallet() {
		return wallet;
	}

	public void setWallet(String wallet) {
		this.wallet = wallet;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

}
