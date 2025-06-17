package com.task.users.service;

import java.util.List;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.task.users.dto.UserDTO;
import com.task.users.exception.DataLoadingException;
import com.task.users.mapper.UserMapper;
import com.task.users.model.User;
import com.task.users.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class UserService {
	private final UserRepository userRepository;
	private final UserMapper userMapper;
	private final ExternalApiService externalApiService;

	public UserService(UserRepository userRepository, UserMapper userMapper, ExternalApiService externalApiService) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
		this.externalApiService = externalApiService;
	}

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

	public User getUserById(Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
	}

}