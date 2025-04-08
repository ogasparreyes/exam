package com.bbva.apx.repository;

import com.bbva.apx.dto.UsersDTO;

import java.util.List;

public interface UsersRepository {
	 List<UsersDTO> getUsers();

	 UsersDTO getUser(Long id);

	Long createUser(UsersDTO user);
	Boolean removeUser(Long id);
}
