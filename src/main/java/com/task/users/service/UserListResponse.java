package com.task.users.service;

import java.util.List;

import com.task.users.dto.UserDTO;

public class UserListResponse {
    private List<UserDTO> users;

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}
