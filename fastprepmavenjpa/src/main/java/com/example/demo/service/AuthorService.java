package com.example.demo.service;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.tree.RowMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Author;

@Service
public class AuthorService
{
	private static final Logger log = LoggerFactory.getLogger(AuthorService.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	public void postConstruct()
	{
		Author a1 = new Author(1, "Manish", "Chauhan");
		Author a2 = new Author(1, "Vineet", "Chauhan");
		List<Author> ls = new ArrayList<>();
		ls.add(a1);ls.add(a2);
		log.info("Creating table");
		jdbcTemplate.execute("DROP TABLE AUTHOR IF EXISTS");
		jdbcTemplate.execute("Create table author ( id serial , first_name varchar(255) ,last_name varchar(255))");
		ls.forEach(author -> jdbcTemplate.update("INSERT INTO AUTHOR (id,first_name,last_name) values(?,?,?)",author.getId(),author.getFirstName(),author.getLastName()));
		log.info("records saved");
		// retrieve saved records 
		log.info("retrieving records");
		ls = jdbcTemplate.query("select * from author", (rs,rowNum)-> new Author(rs.getLong("id"),rs.getString("first_name"),rs.getString("last_name")));
		ls.forEach(a -> log.info(a.getFirstName()+":"+a.getLastName()));
		
		
	}
}
