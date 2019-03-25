package com.poc.learn.rest;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
  }

  @GET
  @Produces({APPLICATION_XML, APPLICATION_JSON})
  public Response getAll() {
    List<Person> allRecords = personRepository.query(p -> true);
    GenericEntity<List<Person>> entity = new GenericEntity<List<Person>>(allRecords) {};
    return Response.ok(entity).build();
  }

  @GET
  @Path("/{personId}")
  @Produces({APPLICATION_XML, APPLICATION_JSON})
  public Response getPersonById(@PathParam("personId") String personId) {
    List<Person> allRecords = personRepository.query(p -> p.getUuid().equals(personId));
    GenericEntity<List<Person>> entity = new GenericEntity<List<Person>>(allRecords) {};
    return Response.ok(entity).build();
  }

  @POST
  @Path("/create")
  @Consumes({APPLICATION_XML, APPLICATION_JSON})
  @Produces({APPLICATION_JSON})
  public Response createPerson(Person person) {
    personRepository.insert(person);
    return Response.ok(new GenericEntity<Person>(person) {}).build();
  }

  @DELETE
  @Path("/delete/{personId}")
  @Consumes({APPLICATION_XML, APPLICATION_JSON})
  @Produces({APPLICATION_JSON})
  public Response deleteOrderById(@PathParam("personId") String personId) {
    personRepository.delete(p -> p.getUuid().equals(personId));
    return Response.ok().build();
  }
}
