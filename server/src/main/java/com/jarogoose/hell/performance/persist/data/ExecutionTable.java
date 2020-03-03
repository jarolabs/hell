package com.jarogoose.hell.performance.persist.data;

import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExecutionTable {
  @Id
  private ConfigurationKey key;
  Collection<MeasurementData> data;
}
