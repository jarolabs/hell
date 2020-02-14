package com.jarogoose.hell.performance.execute;

import com.jarogoose.hell.performance.control.CollectionsCheckupConfig;
import com.jarogoose.hell.performance.control.ExecutionSummaryRow;
import com.jarogoose.hell.performance.persist.AlgorithmExecution;
import com.jarogoose.hell.performance.persist.AlgorithmExecution.Type;
import com.jarogoose.hell.performance.persist.AlgorithmExecutionRepository;
import com.jarogoose.hell.performance.persist.MeasureSummary;
import com.jarogoose.hell.performance.persist.MeasureSummary.Position;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionWorkApi {

  private AlgorithmExecutionRepository storage;
  private ExecutorService executor;

  @Autowired
  public CollectionWorkApi(AlgorithmExecutionRepository storage, ExecutorService executor) {
    this.storage = storage;
    this.executor = executor;
  }

  public void measureCollectionPerformance(CollectionsCheckupConfig params) {
    Callable<AlgorithmExecution> task = () -> {
      final Type type = Type.valueOf(params.type().toUpperCase());
      final Position position =  Position.valueOf(params.position().toUpperCase());
      MeasurementFactory factory = MeasurementFactory.config()
          .of(type)
          .at(position)
          .with(params.size(), params.randomization());

      Collection<MeasureSummary> summary = run(params.times(), factory);

      AlgorithmExecution execution = new AlgorithmExecution(
          System.currentTimeMillis(),
          Type.valueOf(params.type().toUpperCase()),
          params.size(),
          params.randomization(),
          summary);

      storage.save(execution);
      return execution;
    };
    executor.submit(task);
  }

  public Collection<ExecutionSummaryRow> generateSummaryReport() {
    List<AlgorithmExecution> executions = storage.findAll();
    return toExecutionSummaryRows(executions);
  }

  public void clear() {
    storage.deleteAll();
  }

  private Collection<MeasureSummary> run(int times, MeasurementFactory measure) {
    Collection<MeasureSummary> measures = new ArrayList<>();

    for (int i = 0; i < times; i++) {
      measures.add(measure(measure));
    }
    return measures;
  }

  private MeasureSummary measure(MeasurementFactory measure) {
    final long genTime = measure.generation();
    final long sortTime = measure.sorting();
    final long addTime = measure.inserting();
    final long deleteTime = measure.deleting();
    final long retrieveTime = measure.retrieving();

    return new MeasureSummary(
        System.currentTimeMillis(),
        measure.at(),
        genTime,
        sortTime,
        addTime,
        deleteTime,
        retrieveTime);
  }

  private Collection<ExecutionSummaryRow> toExecutionSummaryRows(List<AlgorithmExecution> executions) {
    HashSet<ExecutionSummaryRow> rows = new HashSet<>();
    for (AlgorithmExecution execution : executions) {
      for (MeasureSummary summary : execution.getExecutions()) {
        ExecutionSummaryRow row = ExecutionSummaryRow.builder()
            .type(execution.getType().name())
            .size(execution.getSize())
            .randomization(execution.getRandomization())
            .position(summary.getPosition().name())
            .genTime(summary.getGenerateTimeNanos())
            .sortTime(summary.getSortTimeNanos())
            .addTime(summary.getAddTimeNanos())
            .deleteTime(summary.getDeleteTimeNanos())
            .findTime(summary.getRetrieveTimeNanos())
            .timeMeasure("Millis")
            .build();
        rows.add(row);
      }
    }
    return rows;
  }
}
