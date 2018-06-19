package com.service.ems.services;

import com.service.ems.domain.User;

public interface UserService {
	User findUserByEmail(String email);
	void saveUser(User user, String role);
}