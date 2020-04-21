package com.nstanciu.tutorials.mn.surveys.service;

import com.nstanciu.tutorials.mn.surveys.model.Answer;
import com.nstanciu.tutorials.mn.surveys.model.Question;
import com.nstanciu.tutorials.mn.surveys.model.Survey;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.inject.Singleton;

@Singleton
public class SurveyService {

  private static final Map<String, Survey> surveys = new ConcurrentHashMap<>();
  private static final List<String> uuids = Arrays
      .asList("8c0655da-89ca-441d-8d36-650c8c9807e7",
      "74094da7-01cd-49e4-aec3-fe3e3e529da6",
      "ac68e101-059d-46f8-be05-74cde77e24ab",
      "da407683-7a29-4239-a236-6c19aeb0f1cc",
      "9bbb3fae-fa0d-4240-b717-f4bfa7977366",
      "a8924e98-25f3-4a0e-b2d3-945e7cc0975c",
      "2c39d3ea-fa61-46e6-bd50-90fb590396ac",
      "b5922588-3bfc-47a4-a97e-abb22b3572b4",
      "567a87cf-a8e2-4339-b853-c096b3acd76b",
      "b8ca8d8c-cd92-464f-a008-aa5e420c411f");

  {
    surveys.put(uuids.get(0),
        createRandomSurvey(UUID.fromString(uuids.get(0)),10l));
    surveys.put(uuids.get(1),
        createRandomSurvey(UUID.fromString(uuids.get(1)),5l));
    surveys.put(uuids.get(2),
        createRandomSurvey(UUID.fromString(uuids.get(2)),5l));
    surveys.put(uuids.get(3),
        createRandomSurvey(UUID.fromString(uuids.get(4)),5l));
  }

  private static Survey createRandomSurvey(UUID id, long nbOfQuestions) {
    int nameIndex = new Random().nextInt();
    List<Question> questions = Stream.iterate(0, n -> n + 1)
        .limit(nbOfQuestions)
        .map(integer -> createRandomQuestion())
        .collect(Collectors.toList());

    return Survey.builder()
        .id(id)
        .name("Name"+ nameIndex)
        .description("desc")
        .category("web")
        .endDate(LocalDateTime.now())
        .questions(questions)
        .build();
  }
  private static String[] questionContent = {
      "Fusce suscipit nisl leo, tempor vehicula risus euismod eu.",
      "Vivamus porttitor dolor a iaculis viverra.",
      "Mauris ut felis velit.",
      "Fusce tempus ipsum at lorem dapibus congue.",
      "Proin in metus sagittis, porttitor mi id, pellentesque metus.",
      "Maecenas luctus, tellus quis porta convallis, arcu purus tristique eros, non tincidunt dolor ligula quis massa.",
      "Quisque sapien metus, rutrum ac sollicitudin eget, ultricies at neque.",
      "Integer sed dignissim velit. Sed sed sem sit amet nibh auctor feugiat.",
      "Pellentesque eleifend ligula a vestibulum ornare.",
      "Suspendisse gravida nisl sit amet dolor imperdiet posuere vel sit amet nisl.",
      "Praesent egestas, neque at hendrerit cursus, mauris tortor pharetra odio, et pellentesque velit ante varius elit."
  };

  private static Question createRandomQuestion() {
    List<Answer> answerList = Arrays.asList(createRandomAnswer(),
        createRandomAnswer(),createRandomAnswer(),createRandomAnswer());
    int contentIndex = new Random().nextInt(questionContent.length - 1);

    return Question.builder()
        .id(UUID.randomUUID())
        .content(questionContent[contentIndex])
        .answers(answerList)
        .correctAnswer(answerList.get(0).getId())
        .build();
  }

  private static String[] answerContent = {
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
      "Etiam vulputate et arcu sed consectetur.",
      "Etiam sollicitudin quis tellus quis condimentum.",
      "Quisque ut commodo neque.",
      "Nulla euismod lacus ac tempor consequat.",
      "Mauris molestie mollis maximus."
  };
  private static Answer createRandomAnswer() {
    int contentIndex = new Random().nextInt(answerContent.length - 1);
    return Answer.builder()
        .id(UUID.randomUUID())
        .content(answerContent[contentIndex])
        .build();
  }

  public Collection<Survey> getAllSurveys() {
    return surveys.values();
  }

  public Survey getSurvey(String uuid) {
    return surveys.get(uuid);
  }

  public Survey updateSurvey(String uuid, Survey newSurvey) {
    return surveys.replace(uuid, newSurvey);
  }

  public Survey deleteSurvey(String uuid) {
    return surveys.remove(uuid);
  }

  public void save(Survey survey) {
    surveys.put(survey.getId().toString(),survey);
  }
}
