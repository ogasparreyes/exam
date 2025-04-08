package com.bbva.apx.service.impl;

import com.bbva.apx.dto.UsersDTO;
import com.bbva.apx.repository.UsersRepository;
import com.bbva.apx.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
	private final UsersRepository usersRepository;

	public UsersServiceImpl (UsersRepository usersRepository){
		this.usersRepository = usersRepository;
	}


	@Transactional(readOnly = true)
	@Override
	public List<UsersDTO> getUsers(){
		return usersRepository.getUsers();
	}


	@Transactional(readOnly = true)
	@Override
	public UsersDTO getUser(Long id) {
		return usersRepository.getUser(id);
	}

	@Transactional(readOnly = false)
	@Override
	public String createUser(UsersDTO user) {

		long idUserCreated =   usersRepository.createUser(user);

		return "User created ID:" + idUserCreated;
	}

	@Override
	public String removeUser(Long id) {
		String message = "User not deleted. Please check the user ID and try again.";

		if(usersRepository.removeUser(id)){
			message = "User deleted.";
		}

		return message ;
	}
}
