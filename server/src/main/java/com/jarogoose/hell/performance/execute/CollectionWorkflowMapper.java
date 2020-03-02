package com.jarogoose.hell.performance.execute;

import com.jarogoose.hell.performance.control.request.CheckupConfigurationModel;
import com.jarogoose.hell.performance.control.response.ExecutionSummaryRowModel;
import com.jarogoose.hell.performance.persist.data.ExecutionConfiguration;
import com.jarogoose.hell.performance.persist.data.ExecutionConfiguration.Type;
import com.jarogoose.hell.performance.persist.data.MeasureSummary;
import com.jarogoose.hell.performance.persist.data.MeasureSummary.Position;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

final class CollectionWorkflowMapper {

  private CollectionWorkflowMapper() {}

  static Collection<ExecutionSummaryRowModel> toExecutionSummaryRows(
      List<ExecutionConfiguration> executions) {
    HashSet<ExecutionSummaryRowModel> rows = new HashSet<>();
    for (ExecutionConfiguration config : executions) {
      for (MeasureSummary summary : config.getExecutions()) {
        rows.add(toExecutionSummaryRowModel(config, summary));
      }
    }
    return rows;
  }

  static ExecutionSummaryRowModel toExecutionSummaryRowModel(
      ExecutionConfiguration config, MeasureSummary summary) {
    return ExecutionSummaryRowModel.builder()
        .type(config.getType().name())
        .size(config.getSize())
        .randomization(config.getRandomization())
        .position(summary.getPosition().name())
        .genTime(summary.getGenerateTimeNanos())
        .sortTime(summary.getSortTimeNanos())
        .addTime(summary.getAddTimeNanos())
        .deleteTime(summary.getDeleteTimeNanos())
        .findTime(summary.getRetrieveTimeNanos())
        .timeMeasure("Millis")
        .build();
  }

  static MeasurementFactory toFactory(CheckupConfigurationModel params) {
    final Type type = Type.valueOf(params.type().toUpperCase());
    final Position position =  Position.valueOf(params.position().toUpperCase());
    return MeasurementFactory.config()
        .of(type)
        .at(position)
        .with(params.size(), params.randomization());
  }
}
