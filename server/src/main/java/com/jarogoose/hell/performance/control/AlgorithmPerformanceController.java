package com.jarogoose.hell.performance.control;

import com.jarogoose.hell.performance.control.message.WorkflowConfigurationRequest;
import com.jarogoose.hell.performance.control.message.ExecutionSummaryRowResponse;
import com.jarogoose.hell.performance.execute.CollectionsWorkflowApi;
import com.jarogoose.hell.performance.execute.SummaryReportApi;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AlgorithmPerformanceController {

  private CollectionsWorkflowApi collectionsWorkflowApi;
  private SummaryReportApi summaryReportApi;

  @Autowired
  public AlgorithmPerformanceController(
      CollectionsWorkflowApi collectionsWorkflowApi,
      SummaryReportApi summaryReportApi) {
    this.collectionsWorkflowApi = collectionsWorkflowApi;
    this.summaryReportApi = summaryReportApi;
  }

  @PostMapping("/run-collections-checkup")
  public void runCollectionsCheckup(@RequestBody WorkflowConfigurationRequest config) {
    collectionsWorkflowApi.measurePerformance(config);
  }

  @GetMapping("/show-report")
  public Collection<ExecutionSummaryRowResponse> showReport() {
    return summaryReportApi.generateSummaryReport();
  }

  @DeleteMapping("/clear")
  public void clearSummary() {
    summaryReportApi.clear();
  }
}
