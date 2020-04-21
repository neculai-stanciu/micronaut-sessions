package com.nstanciu.tutorials.mn.surveys.resource;

import com.nstanciu.tutorials.mn.surveys.model.Question;
import com.nstanciu.tutorials.mn.surveys.service.QuestionService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

@Controller("/surveys/{id}/questions")
public class QuestionResource {

  private final QuestionService questionService;

  public QuestionResource(QuestionService surveyService) {
    this.questionService = surveyService;
  }

  @Get
  public List<Question> getAllQuestion(@PathVariable String id) {
    return questionService.getAllQuestions(id);
  }

  @Get("/{qid}")
  public Optional<Question> getQuestion(@PathVariable String id, @PathVariable String qid) {
    return questionService.getQuestion(id, qid);
  }

  @Put("/{qid}")
  public void updateQuestion(@PathVariable String id,
      @PathVariable String qid, @Valid @Body Question question) {
    questionService.updateQuestion(id, question);
  }

  @Post
  public void save(@PathVariable String id,
      @Valid Question question) {
    questionService.saveQuestion(id, question);
  }

  @Delete("/{qid}")
  @SuppressWarnings("rawtypes")
  public void delete(@PathVariable String id, @PathVariable String qid) {
    questionService.deleteQuestion(id,qid);
  }
}
