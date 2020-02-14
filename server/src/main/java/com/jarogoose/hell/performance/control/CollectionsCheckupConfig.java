package com.jarogoose.hell.performance.control;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Builder
@Getter
@Accessors(fluent = true)
@ToString
public class CollectionsCheckupConfig {
  @JsonProperty private final String type;
  @JsonProperty private final String position;
  @JsonProperty private final int size;
  @JsonProperty private final int randomization;
  @JsonProperty private final int times;
}
