package com.jarogoose.hell.performance.control;

import com.jarogoose.hell.performance.control.request.CheckupConfigurationModel;
import com.jarogoose.hell.performance.control.response.ExecutionSummaryRowModel;
import com.jarogoose.hell.performance.execute.CheckupWorkflowApi;
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
public class AlgorithmPerformanceReportController {

  private CheckupWorkflowApi checkupWorkflowApi;
  private SummaryReportApi summaryReportApi;

  @Autowired
  public AlgorithmPerformanceReportController(
      CheckupWorkflowApi checkupWorkflowApi,
      SummaryReportApi summaryReportApi) {
    this.checkupWorkflowApi = checkupWorkflowApi;
    this.summaryReportApi = summaryReportApi;
  }

  @PostMapping("/run-collections-checkup")
  public void runCollectionsCheckup(@RequestBody CheckupConfigurationModel config) {
    checkupWorkflowApi.measureCollectionPerformance(config);
  }

  @GetMapping("/show-report")
  public Collection<ExecutionSummaryRowModel> showReport() {
    return summaryReportApi.generateSummaryReport();
  }

  @DeleteMapping("/clear")
  public void clearSummary() {
    summaryReportApi.clear();
  }
}
