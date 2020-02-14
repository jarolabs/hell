package com.jarogoose.hell.performance.persist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeasureSummary {

  public enum Position {
    BEGINNING,
    MIDDLE,
    END,
  }

  @Id
  private long id;
  private Position position;
  private long generateTimeNanos;
  private long sortTimeNanos;
  private long addTimeNanos;
  private long deleteTimeNanos;
  private long retrieveTimeNanos;
}
