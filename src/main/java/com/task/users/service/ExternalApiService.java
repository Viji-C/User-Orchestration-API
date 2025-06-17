package com.task.users.service;

import java.time.Duration;
import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.task.users.dto.UserDTO;
import com.task.users.exception.ExternalApiException;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ExternalApiService {

	private final RetryTemplate retryTemplate;
	private final ExternalApiProperties properties;

	public ExternalApiService(RetryTemplate retryTemplate, ExternalApiProperties properties) {
		this.retryTemplate = retryTemplate;
		this.properties = properties;
	}

	public List<UserDTO> fetchAllUsers() {
		log.debug("Fetching users from external API...");

		return retryTemplate.execute(context -> {
			try {
				WebClient webClient = WebClient.builder().baseUrl("https://dummyjson.com").build();
				UserListResponse response = webClient.get().uri(properties.getUsersEndpoint()).retrieve()
						.onStatus(HttpStatusCode::isError,
								clientResponse -> Mono.error(new ExternalApiException(
										"External API returned error: " + clientResponse.statusCode())))
						.bodyToMono(UserListResponse.class).block(Duration.ofMillis(properties.getTimeoutMs()));

				if (response == null || response.getUsers() == null) {
					throw new ExternalApiException("No user data received from external API");
				}

				return response.getUsers();

			} catch (Exception e) {
				log.warn("Attempt {} failed: {}", context.getRetryCount() + 1, e.getMessage());
				throw new ExternalApiException("Failed to fetch users from external API", e);
			}
		});
	}

}
