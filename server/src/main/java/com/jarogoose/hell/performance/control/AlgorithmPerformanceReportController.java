package com.jarogoose.hell.performance.control;

import com.jarogoose.hell.performance.execute.CollectionWorkApi;
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

  private CollectionWorkApi service;

  @Autowired
  public AlgorithmPerformanceReportController(CollectionWorkApi service) {
    this.service = service;
  }

  @PostMapping("/run-collections-checkup")
  public void runCollectionsCheckup(@RequestBody CollectionsCheckupConfig config) {
    service.measureCollectionPerformance(config);
  }

  @GetMapping("/show-report")
  public Collection<ExecutionSummaryRow> showReport() {
    return service.generateSummaryReport();
  }

  @DeleteMapping("/clear")
  public void clearSummary() {
    service.clear();
  }
}
