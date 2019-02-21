package com.poc.learn.model;

import java.beans.IntrospectionException;

import org.junit.jupiter.api.Test;

import net.codebox.javabeantester.JavaBeanTester;

class PersonTest {

  @Test
  void test() throws IntrospectionException {
    JavaBeanTester.test(Person.class);
  }
}
