package com.poc.learn;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/** Hello world! */
public class App extends GuiceServletContextListener {
	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new AppServletModule());
	}
}
