package com.task.users.controller;

import java.time.LocalDateTime;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.users.model.User;
import com.task.users.payload.ApiResponse;
import com.task.users.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/load")
	@Operation(summary = "Load users from external API")
	public ResponseEntity<ApiResponse> loadUsers() {
		log.info("Loading users from external API");
		userService.loadUsersFromExternalApi();

		ApiResponse response = new ApiResponse(true, "Users loaded successfully", LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping
    @Operation(summary = "Search users by text")
    public ResponseEntity<Page<User>> searchUsers(
            @RequestParam(required = false) String search,
            @ParameterObject @PageableDefault(size = 20) Pageable pageable) {
        log.debug("Searching users with query: {}", search);
        return ResponseEntity.ok(userService.searchUsers(search, pageable));
    }

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}

}