package com.poc.learn;

import java.util.Optional;

import com.google.inject.TypeLiteral;
import com.google.inject.servlet.ServletModule;
import com.poc.learn.model.Person;
import com.poc.learn.repository.DataRepository;
import com.poc.learn.repository.PersonRepository;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class AppServletModule extends ServletModule {

	@Override
	protected void configureServlets() {
		bind(new TypeLiteral<DataRepository<Person>>() {
		}).to(PersonRepository.class);

		Optional.ofNullable(new PackagesResourceConfig("com.poc.learn.rest")).get().getClasses()
				.forEach(res -> bind(res));

		serve("/services/*").with(GuiceContainer.class);
	}

}
