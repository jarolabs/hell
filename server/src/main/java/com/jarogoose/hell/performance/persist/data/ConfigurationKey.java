package com.jarogoose.hell.performance.persist.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfigurationKey {

  public enum Type {
    ARRAY_LIST,
    LINKED_LIST,
  }

  public enum Position {
    BEGINNING,
    MIDDLE,
    END,
  }

  private Type type;
  private Position position;
  private long size;
  private long randomization;
}
