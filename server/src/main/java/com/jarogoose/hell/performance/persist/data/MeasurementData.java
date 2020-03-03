package com.jarogoose.hell.performance.persist.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementData {
  private long generateTimeNanos;
  private long sortTimeNanos;
  private long addTimeNanos;
  private long deleteTimeNanos;
  private long retrieveTimeNanos;
}
