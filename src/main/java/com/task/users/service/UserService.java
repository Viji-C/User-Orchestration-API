package com.task.users.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.task.users.dto.UserDTO;
import com.task.users.exception.DataLoadingException;
import com.task.users.mapper.UserMapper;
import com.task.users.model.User;
import com.task.users.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final UserMapper userMapper;
	private final ExternalApiService externalApiService;

	@Transactional
	public void loadUsersFromExternalApi() {
		log.info("Starting user data loading process");
		try {
			List<UserDTO> userDTOs = externalApiService.fetchAllUsers();
			List<User> users = userDTOs.stream().map(userMapper::toEntity).toList();

			userRepository.saveAll(users);
			log.info("Successfully loaded {} users", users.size());
		} catch (Exception e) {
			log.error("Failed to load users: {}", e.getMessage());
			throw new DataLoadingException("Failed to load users from external API");
		}
	}

	@Transactional
	public Page<User> searchUsers(String search, Pageable pageable) {
		log.debug("Searching users with query: {}", search);
		if (search == null || search.trim().isEmpty()) {
			return userRepository.findAll(pageable);
		}
		return userRepository.searchUsers(search, pageable);
	}

	@Transactional
	public User findByIdOrEmail(String identifier) {
		log.debug("Fetching user with identifier: {}", identifier);
		try {
			Long id = Long.parseLong(identifier);
			return userRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
		} catch (NumberFormatException e) {
			return userRepository.findByEmail(identifier)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + identifier));
		}
	}

}