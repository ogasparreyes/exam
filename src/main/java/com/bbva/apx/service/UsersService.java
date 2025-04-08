package com.bbva.apx.service;

import com.bbva.apx.dto.UsersDTO;

import java.util.List;

public interface UsersService {
	 List<UsersDTO> getUsers();

	 UsersDTO getUser(Long id);

	 String  createUser(UsersDTO user);

	 String removeUser(Long id);
}
