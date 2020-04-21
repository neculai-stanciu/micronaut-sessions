package com.nstanciu.tutorials.mn.surveys;

import io.micronaut.context.ApplicationContext;
import io.micronaut.test.annotation.MicronautTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
public class ApplicationTest {

  @Inject
  private ApplicationContext context;

  @Test
  public void appShouldRun() {
    context.getEnvironment();
  }
}
