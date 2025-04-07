package com.bbva.apx.repository.impl;

import com.bbva.apx.dto.UsersDTO;
import com.bbva.apx.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UsersRepositoryImpl implements UsersRepository {


	private final JdbcTemplate jdbcTemplate;

	public UsersRepositoryImpl(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate =   jdbcTemplate;
	}


	@Override
	public List<UsersDTO> getUsers(){
		final String query = "SELECT ID, NAME FROM USERS;";

		return jdbcTemplate.query(query, new RowMapper<UsersDTO>() {
			@Override
			public UsersDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				int indice = 0;
				UsersDTO dto = new UsersDTO();
				dto.setId(rs.getInt(++indice));
				dto.setNombre(rs.getString(++indice));
				return dto;
			}
		});
	}

	@Override
	public UsersDTO getUser(Long id) {
		final String query = "SELECT ID, NAME FROM USERS WHERE ID= ?;";

		return jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<UsersDTO>(){


			@Override
			public UsersDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

				UsersDTO dto = new UsersDTO();
				dto.setId(rs.getInt(rs.getInt("ID")));
				dto.setNombre(rs.getString("NAME"));
				return dto;

			}
		});
	}



}
