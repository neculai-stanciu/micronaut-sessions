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
/surverys/{id}

/surverys/{id}/questions
/surverys/{id}/questions/{id}

/surverys/{id}/questions/{id}/answers
/surverys/{id}/questions/{id}/answers/{id}


