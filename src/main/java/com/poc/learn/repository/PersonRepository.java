package com.poc.learn.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import com.poc.learn.model.Person;

public class PersonRepository implements DataRepository<Person> {

  private List<Person> persons = new ArrayList<>();

  @Override
  public void insert(Person t) {
    persons.add(t);
  }

  @Override
  public void delete(Predicate<Person> condition) {
    persons.removeIf(condition);
  }

  @Override
  public List<Person> query(Predicate<Person> filter) {
    return persons.stream().filter(filter).collect(Collectors.toList());
  }

  public int size() {
    return persons.size();
  }
}
