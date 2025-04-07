package com.bbva.apx.repository;

import com.bbva.apx.dto.UsersDTO;

import java.util.List;

public interface UsersRepository {
	public List<UsersDTO> getUsers();

	public UsersDTO getUser(Long id);
}
