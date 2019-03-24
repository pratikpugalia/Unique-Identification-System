package com.poc.learn.rest;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import com.google.inject.Inject;
import com.poc.learn.model.Person;
import com.poc.learn.repository.DataRepository;

@Path("person")
public class PersonService {

	private DataRepository<Person> personRepository;

	@Inject
	public PersonService(DataRepository<Person> personRepository) {
		this.personRepository = personRepository;
		this.personRepository.insert(new Person("123", "abcd"));
	}

	@GET
	@Produces({ APPLICATION_XML, APPLICATION_JSON })
	public Response getAll() {
		List<Person> allRecords = personRepository.query(p -> true);
		GenericEntity<List<Person>> entity = new GenericEntity<List<Person>>(allRecords) {
		};
		return Response.ok(entity).build();
	}
}
