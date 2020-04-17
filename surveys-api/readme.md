# surveys-api

A simple REST api to demonstrate Micronaut features.

## Model

Survey:
    - uuid
    - name
    - description
    - category
    - endDate
    - list<Question>

Question:
    - uuid
    - content
    - list<Answer>
    - correctAnswer: uuid
Answer:
    - uuid
    - content

## Flow

Endpoints:
/surveys - lista de surverys
/surveys/{id}

/surveys/{id}/questions
/surveys/{id}/questions/{id}

~~/surveys/{id}/questions/{id}/answers~~
~~/surveys/{id}/questions/{id}/answers/{id}~~~



