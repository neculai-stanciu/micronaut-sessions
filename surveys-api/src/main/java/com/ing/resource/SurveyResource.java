package com.ing.resource;

import com.ing.model.Survey;
import com.ing.service.SurveyService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import javax.validation.Valid;

@Controller("/surveys")
public class SurveyResource {
  private SurveyService surveyService;

  public SurveyResource(SurveyService surveyService) {
    this.surveyService = surveyService;
  }

  @Get
  public Flowable<Survey> getSurveys() {
    return Flowable.fromIterable(surveyService.getAllSurveys());
  }

  @Get("/{id}")
  public Maybe<Survey> getSurvey(@PathVariable("id") String uuid) {
    return Maybe.just(surveyService.getSurvey(uuid));
  }

  @Put("/{id}")
  public void updateSurvey(@PathVariable("id") String uuid,
      @Body @Valid Survey survey) {
    surveyService.updateSurvey(uuid, survey);
  }

  @Post
  public void save(@Valid @Body Survey survey) {
    surveyService.save(survey);
  }
}
