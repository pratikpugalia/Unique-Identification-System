package com.poc.learn.model;

public class Person {
  private String uuid;
  private String name;

  public Person() {}

  public Person(String uuid, String name) {
    this.uuid = uuid;
    this.name = name;
  }

  public String getUuid() {
    return this.uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
