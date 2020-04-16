package com.ing.config;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.umd.cs.findbugs.annotations.Nullable;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.jackson.JacksonConfiguration;
import io.micronaut.jackson.ObjectMapperFactory;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.inject.Singleton;

@Factory
@Replaces(ObjectMapperFactory.class)
public class CustomObjectMapperFactory extends ObjectMapperFactory {

  @Override
  @Singleton
  @Replaces(ObjectMapper.class)
  public ObjectMapper objectMapper(@Nullable JacksonConfiguration jacksonConfiguration,
      @Nullable JsonFactory jsonFactory) {
    jacksonConfiguration.setDateFormat("dd-MM-yyyy hh:mm");
    return super.objectMapper(jacksonConfiguration, jsonFactory);
  }
}
