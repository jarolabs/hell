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
public class ExecutionSummaryRow {
  @JsonProperty private final String type;
  @JsonProperty private final String position;
  @JsonProperty private final long size;
  @JsonProperty private final long randomization;
  @JsonProperty private final long genTime;
  @JsonProperty private final long sortTime;
  @JsonProperty private final long addTime;
  @JsonProperty private final long deleteTime;
  @JsonProperty private final long findTime;
  @JsonProperty private final String timeMeasure;
}
