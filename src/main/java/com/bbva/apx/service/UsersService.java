package com.bbva.apx.service;

import com.bbva.apx.dto.UsersDTO;

import java.util.List;

public interface UsersService {
	public List<UsersDTO> getUsers();

	public UsersDTO getUser(Long id);
}
