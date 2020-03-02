package com.jarogoose.hell.performance.execute;

import static com.jarogoose.hell.performance.execute.CollectionWorkflowMapper.toFactory;

import com.jarogoose.hell.performance.control.request.CheckupConfigurationModel;
import com.jarogoose.hell.performance.persist.ExecutionConfiguration;
import com.jarogoose.hell.performance.persist.ExecutionConfiguration.Type;
import com.jarogoose.hell.performance.persist.AlgorithmExecutionRepository;
import com.jarogoose.hell.performance.persist.MeasureSummary;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckupWorkflowApi {

  private AlgorithmExecutionRepository storage;
  private ExecutorService executor;

  @Autowired
  public CheckupWorkflowApi(AlgorithmExecutionRepository storage, ExecutorService executor) {
    this.storage = storage;
    this.executor = executor;
  }

  public void measureCollectionPerformance(CheckupConfigurationModel params) {
    Callable<ExecutionConfiguration> task = () -> {
      Collection<MeasureSummary> summary = run(params.times(), toFactory(params));

      ExecutionConfiguration execution = new ExecutionConfiguration(
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
}
