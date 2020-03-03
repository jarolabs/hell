package com.jarogoose.hell.performance.execute;

import com.jarogoose.hell.performance.control.message.WorkflowConfigurationRequest;
import com.jarogoose.hell.performance.control.message.ExecutionSummaryRowResponse;
import com.jarogoose.hell.performance.persist.data.ConfigurationKey;
import com.jarogoose.hell.performance.persist.data.ConfigurationKey.Position;
import com.jarogoose.hell.performance.persist.data.ConfigurationKey.Type;
import com.jarogoose.hell.performance.persist.data.ExecutionRecord;
import com.jarogoose.hell.performance.persist.data.MeasurementData;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

final class CollectionWorkflowMapper {

  private CollectionWorkflowMapper() {}

  static Collection<ExecutionSummaryRowResponse> toExecutionSummaryRows(
      List<ExecutionRecord> executions) {
    HashSet<ExecutionSummaryRowResponse> rows = new HashSet<>();
    for (ExecutionRecord record : executions) {
      for (MeasurementData measurement : record.getData()) {
        rows.add(toExecutionSummaryRowModel(record.getKey(), measurement));
      }
    }
    return rows;
  }

  static ExecutionSummaryRowResponse toExecutionSummaryRowModel(
      ConfigurationKey config, MeasurementData measuremen) {
    return ExecutionSummaryRowResponse.builder()
        .type(config.getType().name())
        .size(config.getSize())
        .randomization(config.getRandomization())
        .position(config.getPosition().name())
        .genTime(measuremen.getGenerateTimeNanos())
        .sortTime(measuremen.getSortTimeNanos())
        .addTime(measuremen.getAddTimeNanos())
        .deleteTime(measuremen.getDeleteTimeNanos())
        .findTime(measuremen.getRetrieveTimeNanos())
        .timeMeasure("Millis")
        .build();
  }

  static MeasurementFactory toFactory(WorkflowConfigurationRequest params) {
    final Type type = Type.valueOf(params.type().toUpperCase());
    final Position position =  Position.valueOf(params.position().toUpperCase());
    return MeasurementFactory.config()
        .of(type)
        .at(position)
        .with(params.size(), params.randomization());
  }

  static ConfigurationKey toConfigurationKey(WorkflowConfigurationRequest config) {
    return new ConfigurationKey(
        Type.valueOf(config.type().toUpperCase()),
        Position.valueOf(config.position().toUpperCase()),
        config.size(),
        config.randomization()
    );
  }
}
