package com.poc.learn;

import javax.inject.Inject;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.poc.learn.model.Person;
import com.poc.learn.repository.DataRepository;

/** Hello world! */
public class App {
  @Inject private DataRepository<Person> personRepository;
  private Injector injector;

  public App() {
    this.injector = Guice.createInjector(new AppModule());
    this.injector.injectMembers(this);
  }

  public static void main(String[] args) {
    System.out.println("Hello World!");
    App app = new App();
    app.personRepository.insert(new Person("123", "someName"));
    System.out.println("Working fine!");
  }
}
