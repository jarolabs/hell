package com.jarogoose.hell.performance.execute;

import static com.jarogoose.hell.performance.execute.CollectionWorkflowMapper.toExecutionSummaryRows;

import com.jarogoose.hell.performance.control.response.ExecutionSummaryRowModel;
import com.jarogoose.hell.performance.persist.data.ConfigurationKey;
import com.jarogoose.hell.performance.persist.ExecutionStorage;
import com.jarogoose.hell.performance.persist.data.ExecutionTable;
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

  public Collection<ExecutionSummaryRowModel> generateSummaryReport() {
    List<ExecutionTable> executions = storage.findAll();
    return toExecutionSummaryRows(executions);
  }

  public void clear() {
    storage.deleteAll();
  }
}
