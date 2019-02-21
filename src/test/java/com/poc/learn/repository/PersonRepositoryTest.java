package com.poc.learn.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.poc.learn.model.Person;

class PersonRepositoryTest {

  private PersonRepository personRepository;

  @BeforeEach
  void setUp() throws Exception {
    personRepository = new PersonRepository();
    personRepository.insert(new Person("uuid", "name"));
  }

  @Test
  void shouldInsert() {
    personRepository.insert(new Person("uuid2", "name2"));
    assertEquals(2, personRepository.size());
  }

  @Test
  void shouldDeleteIfPresent() {
    personRepository.delete(person -> person.getName().equals("name"));
    assertEquals(0, personRepository.size());
  }

  @Test
  void shouldReturnPersonIfPresent() {
    List<Person> query = personRepository.query(person -> person.getName().equals("name"));
    assertEquals(1, query.size());
  }
}
