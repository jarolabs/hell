package com.jarogoose.hell.performance.execute;

import static com.jarogoose.hell.performance.execute.CollectionWorkflowMapper.toExecutionSummaryRows;

import com.jarogoose.hell.performance.control.message.ExecutionSummaryRowResponse;
import com.jarogoose.hell.performance.persist.ExecutionStorage;
import com.jarogoose.hell.performance.persist.data.ExecutionRecord;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummaryReportApi {

  private ExecutionStorage storage;

  @Autowired
  public SummaryReportApi(ExecutionStorage storage) {
    this.storage = storage;
  }

  public Collection<ExecutionSummaryRowResponse> generateSummaryReport() {
    List<ExecutionRecord> executions = storage.findAll();
    return toExecutionSummaryRows(executions);
  }

  public void clear() {
    storage.deleteAll();
  }
}
