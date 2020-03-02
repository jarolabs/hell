package com.jarogoose.hell.performance.persist.data;

import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExecutionConfiguration {

  public enum Type {
    ARRAY_LIST,
    LINKED_LIST,
  }

  @Id
  private long id;
  private Type type;
  private long size;
  private long randomization;
  private Collection<MeasureSummary> executions;
}
