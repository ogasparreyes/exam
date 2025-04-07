package com.bbva.apx.controller;

import com.bbva.apx.dto.UsersDTO;
import com.bbva.apx.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apx")
public class UsersController {

	private final UsersService usersService;
	public UsersController(UsersService usersService){
		this.usersService = usersService;
	}

	@GetMapping(value = "/user/{idUser}", produces = "application/json")
	public UsersDTO getUserById(@PathVariable String idUser){

		return usersService.getUser(Long.parseLong(idUser));
	}



	@GetMapping(value = "/users", produces = "application/json")
	public List<UsersDTO> getUsers(){
		return usersService.getUsers();
	}
}
