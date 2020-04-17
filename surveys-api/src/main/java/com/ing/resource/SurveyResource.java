package com.ing.resource;

import com.ing.model.Survey;
import com.ing.service.MessageSource;
import com.ing.service.SurveyService;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import java.util.HashMap;
import java.util.Map;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

@Controller("/surveys")
public class SurveyResource {
  private SurveyService surveyService;
  private MessageSource messageSource;

  public SurveyResource(SurveyService surveyService, MessageSource messageSource) {
    this.surveyService = surveyService;
    this.messageSource = messageSource;
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

  @Delete("/{id}")
  public void deleteSurvey(@PathVariable String id) {
    surveyService.deleteSurvey(id);
  }

  @Post
  public void save(@Valid @Body Survey survey) {
    surveyService.save(survey);
  }

  @SuppressWarnings("rawtypes")
  @Error(exception = ConstraintViolationException.class)
  public Map<String, Object> onSavedFailed(HttpRequest request, ConstraintViolationException ex) {
    final Map<String, Object> model = new HashMap<>();
    model.put("errors", messageSource.violationsMessages(ex.getConstraintViolations()));
    return model;
  }
}
