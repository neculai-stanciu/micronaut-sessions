package com.nstanciu.tutorials.mn.surveys.model;

import io.micronaut.core.annotation.Introspected;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Introspected
public class Answer {
  private UUID id;
  private String content;
}
