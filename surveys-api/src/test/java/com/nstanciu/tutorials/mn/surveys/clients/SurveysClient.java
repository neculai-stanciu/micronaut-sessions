package com.nstanciu.tutorials.mn.surveys.clients;

import com.nstanciu.tutorials.mn.surveys.model.Survey;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import java.util.List;

@Client("/surveys")
public interface SurveysClient {

  @Get
  List<Survey> getAllSurveys();
}
