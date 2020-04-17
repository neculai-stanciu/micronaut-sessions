package com.ing.service;

import static java.util.stream.Collectors.toList;

import com.ing.model.Question;
import com.ing.model.Survey;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.inject.Singleton;

@Singleton
public class QuestionService {

  private SurveyService surveyService;

  public QuestionService(SurveyService surveyService) {
    this.surveyService = surveyService;
  }

  public Optional<Question> getQuestion(String surveyId, String id) {
    return surveyService.getSurvey(surveyId)
        .getQuestions().stream()
        .filter(question -> question.getId().equals(UUID.fromString(id)))
        .findAny();
  }

  public List<Question> getAllQuestions(String surveyId) {
    return surveyService.getSurvey(surveyId)
        .getQuestions();
  }

  private void updateAllQuestions(String surveyId,List<Question> questions) {
    Survey survey = surveyService.getSurvey(surveyId);
    survey.setQuestions(questions);
    surveyService.updateSurvey(surveyId,survey);
  }

  public void updateQuestion(String surveyId, Question updatedQuestion) {
    List<Question> questions = getAllQuestions(surveyId)
        .stream()
        .filter(question -> question.getId().equals(updatedQuestion.getId()))
        .map(question -> updatedQuestion)
        .collect(toList());
    updateAllQuestions(surveyId,questions);
  }

  public void deleteQuestion(String surveyId, String qustionId) {
    List<Question> questions = getAllQuestions(surveyId)
        .stream()
        .filter(question -> question.getId().equals(UUID.fromString(qustionId)))
        .collect(toList());
    updateAllQuestions(surveyId,questions);
  }

  public void saveQuestion(String surveyId, Question question) {
    List<Question> questions = getAllQuestions(surveyId);
    questions.add(question);
    updateAllQuestions(surveyId,questions);
  }
}
