package com.poc.learn.repository;

import java.util.List;
import java.util.function.Predicate;

public interface DataRepository<T> {

  void insert(T t);

  void delete(Predicate<T> condition);

  List<T> query(Predicate<T> filter);
}
