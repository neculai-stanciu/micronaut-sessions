package com.ing.model;

import io.micronaut.core.annotation.Introspected;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Introspected
public class Survey {
  private UUID id;
  @Size(min = 2)
  private String name;
  @Size(min = 2)
  private String description;
  @NotBlank
  private String category;
  private LocalDateTime endDate;
  private List<Question> questions;
}
