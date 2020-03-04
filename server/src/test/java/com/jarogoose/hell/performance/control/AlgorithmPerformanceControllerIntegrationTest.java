package com.jarogoose.hell.performance.control;

import static org.assertj.core.api.Assertions.assertThat;

import com.jarogoose.hell.performance.control.message.ExecutionSummaryRowResponse;
import com.jarogoose.hell.performance.control.message.WorkflowConfigurationRequest;
import java.util.Collection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Profile("test")
class AlgorithmPerformanceControllerIntegrationTest {

  @AfterEach
  void tearDown(@Autowired AlgorithmPerformanceController controller) {
    controller.clearSummary();
  }

  @Test
  void showReport_respondNonEmpty(@Autowired AlgorithmPerformanceController controller) {
    // Scenario:
    //  - db has at least one record.
    //  - execute simplest checkup request.
    //  - execute showReport request.
    //  - verify report is not empty.

    // init
    WorkflowConfigurationRequest request = WorkflowConfigurationRequest.builder()
        .type("array_list")
        .position("beginning")
        .size(1000)
        .randomization(100)
        .times(1)
        .build();

    // execute
    controller.runCollectionsCheckup(request);
    Collection<ExecutionSummaryRowResponse> result = controller.showReport();

    // verify
    assertThat(result).isNotEmpty();
  }

  @Test
  void showReport_respondEmpty(@Autowired AlgorithmPerformanceController controller) {
    // Scenario:
    //  - db is empty.
    //  - execute showReport request.
    //  - verify report is empty.
    Collection<ExecutionSummaryRowResponse> result = controller.showReport();
    assertThat(result).withFailMessage("").isEmpty();
  }
}
