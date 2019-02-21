package com.poc.learn;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.poc.learn.model.Person;
import com.poc.learn.repository.DataRepository;
import com.poc.learn.repository.PersonRepository;

public class AppModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(new TypeLiteral<DataRepository<Person>>() {}).to(PersonRepository.class);
  }
}
