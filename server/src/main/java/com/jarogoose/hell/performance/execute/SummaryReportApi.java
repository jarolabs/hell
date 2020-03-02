package com.jarogoose.hell.performance.execute;

import static com.jarogoose.hell.performance.execute.CollectionWorkflowMapper.toExecutionSummaryRows;

import com.jarogoose.hell.performance.control.response.ExecutionSummaryRowModel;
import com.jarogoose.hell.performance.persist.ExecutionConfiguration;
import com.jarogoose.hell.performance.persist.AlgorithmExecutionRepository;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummaryReportApi {

  private AlgorithmExecutionRepository storage;

  @Autowired
  public SummaryReportApi(AlgorithmExecutionRepository storage) {
    this.storage = storage;
  }

  public Collection<ExecutionSummaryRowModel> generateSummaryReport() {
    List<ExecutionConfiguration> executions = storage.findAll();
    return toExecutionSummaryRows(executions);
  }

  public void clear() {
    storage.deleteAll();
  }
}
