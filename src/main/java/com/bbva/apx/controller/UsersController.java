package com.bbva.apx.controller;

import com.bbva.apx.dto.UsersDTO;
import com.bbva.apx.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/apx")
public class UsersController {

	private final UsersService usersService;
	public UsersController(UsersService usersService){
		this.usersService = usersService;
	}

	@GetMapping(value = "/user/{idUser}", produces = "application/json")
	public UsersDTO getUserById(@PathVariable String idUser){
		System.out.println(idUser);
		return usersService.getUser(Long.parseLong(idUser));
	}

	@GetMapping(value = "/users", produces = "application/json")
	public List<UsersDTO> getUsers(){
		return usersService.getUsers();
	}


	@PostMapping(value = "/user", produces = "application/json")
	public String createUser(@RequestBody UsersDTO user){
		return usersService.createUser(user);
	}

	@DeleteMapping(value = "/user/{idUser}", produces = "application/json")
		public String removeUser(@PathVariable String idUser){
		return usersService.removeUser(Long.parseLong(idUser));
	}
}
