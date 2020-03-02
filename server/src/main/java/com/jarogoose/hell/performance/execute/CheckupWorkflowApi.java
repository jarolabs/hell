package com.jarogoose.hell.performance.execute;

import static com.jarogoose.hell.performance.execute.CollectionWorkflowMapper.toFactory;

import com.jarogoose.hell.performance.control.request.CheckupConfigurationModel;
import com.jarogoose.hell.performance.persist.data.ExecutionConfiguration;
import com.jarogoose.hell.performance.persist.data.ExecutionConfiguration.Type;
import com.jarogoose.hell.performance.persist.ExecutionConfigurationStorage;
import com.jarogoose.hell.performance.persist.data.MeasureSummary;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckupWorkflowApi {

  private ExecutionConfigurationStorage storage;
  private ExecutorService executor;

  @Autowired
  public CheckupWorkflowApi(ExecutionConfigurationStorage storage, ExecutorService executor) {
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
