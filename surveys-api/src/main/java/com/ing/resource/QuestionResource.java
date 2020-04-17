package com.ing.resource;

import com.ing.model.Question;
import com.ing.service.QuestionService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
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
  public CompletableFuture<HttpResponse<Question>> save(@PathVariable String id,
      @Valid CompletableFuture<Question> question) {

    return question.thenApply(q -> {
      questionService.saveQuestion(id, q);
      return HttpResponse.created(q);
    });
  }

  @Delete("/{qid}")
  @SuppressWarnings("rawtypes")
  public CompletableFuture<HttpResponse> delete(@PathVariable String id, @PathVariable String qid) {
    return CompletableFuture.runAsync(() -> questionService.deleteQuestion(id,qid))
        .thenApply(aVoid -> HttpResponse.accepted());
  }
}
