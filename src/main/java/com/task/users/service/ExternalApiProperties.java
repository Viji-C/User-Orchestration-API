package com.task.users.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "external.api")
public class ExternalApiProperties {
	private String usersEndpoint;
	private long timeoutMs;

	public String getUsersEndpoint() {
		return usersEndpoint;
	}

	public void setUsersEndpoint(String usersEndpoint) {
		this.usersEndpoint = usersEndpoint;
	}

	public long getTimeoutMs() {
		return timeoutMs;
	}

	public void setTimeoutMs(long timeoutMs) {
		this.timeoutMs = timeoutMs;
	}

}
