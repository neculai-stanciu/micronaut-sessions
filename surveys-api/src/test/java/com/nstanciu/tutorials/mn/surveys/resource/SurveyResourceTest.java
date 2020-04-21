package com.nstanciu.tutorials.mn.surveys.resource;

import com.nstanciu.tutorials.mn.surveys.clients.SurveysClient;
import com.nstanciu.tutorials.mn.surveys.model.Survey;
import io.micronaut.test.annotation.MicronautTest;
import java.util.List;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@MicronautTest
public class SurveyResourceTest {

  @Inject
  private SurveysClient client;

  @Test
  @DisplayName("Should return a list of surveys")
  public void shouldReturnSurveys() {
    List<Survey> surveysList = client.getAllSurveys();
    Assertions.assertAll(() -> {
      Assertions.assertNotNull(surveysList);
    });
  }
}
