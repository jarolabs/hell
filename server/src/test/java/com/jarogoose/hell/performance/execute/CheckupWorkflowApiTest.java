package com.jarogoose.hell.performance.execute;

import com.jarogoose.hell.performance.persist.AlgorithmExecutionRepository;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CheckupWorkflowApiTest {

  private CheckupWorkflowApi api;

  @Mock AlgorithmExecutionRepository mockStorage;

  @BeforeEach
  void beforeAll() {
    MockitoAnnotations.initMocks(this);
    api = new CheckupWorkflowApi(mockStorage, Executors.newSingleThreadExecutor());
  }

  @Test()
  @DisplayName("Contains two summary rows when db returns two executions")
  void generateSummaryReport() {
//    // init
//    MeasureSummary summary = new MeasureSummary();
//    summary.setPosition(Position.BEGINNING);
//    List<MeasureSummary> summs = Collections.singletonList(summary);
//    ExecutionConfiguration execution = new ExecutionConfiguration();
//    execution.setExecutions(summs);
//    execution.setType(Type.ARRAY_LIST);
//
//    // mock
//    List<ExecutionConfiguration> listOfTwo = Arrays.asList(execution, execution);
//    when(mockStorage.findAll()).thenReturn(listOfTwo);
//
//    // execute
//    Collection<ExecutionSummaryRowModel> actual = api
//        .generateSummaryReport();
//
//    // verify
//    Assertions.assertEquals(2, actual.size());
  }
}
