package com.jarogoose.hell.performance.execute;

import static org.mockito.Mockito.when;

import com.jarogoose.hell.performance.control.ExecutionSummaryRow;
import com.jarogoose.hell.performance.persist.AlgorithmExecution;
import com.jarogoose.hell.performance.persist.AlgorithmExecution.Type;
import com.jarogoose.hell.performance.persist.AlgorithmExecutionRepository;
import com.jarogoose.hell.performance.persist.MeasureSummary;
import com.jarogoose.hell.performance.persist.MeasureSummary.Position;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Assertions;
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
class CollectionWorkApiTest {

  private CollectionWorkApi api;

  @Mock AlgorithmExecutionRepository mockStorage;

  @BeforeEach
  void beforeAll() {
    MockitoAnnotations.initMocks(this);
    api = new CollectionWorkApi(mockStorage, Executors.newSingleThreadExecutor());
  }

  @Test()
  @DisplayName("Contains two summary rows when db returns two executions")
  void generateSummaryReport() {
    // init
    MeasureSummary summary = new MeasureSummary();
    summary.setPosition(Position.BEGINNING);
    List<MeasureSummary> summs = Collections.singletonList(summary);
    AlgorithmExecution execution = new AlgorithmExecution();
    execution.setExecutions(summs);
    execution.setType(Type.ARRAY_LIST);

    // mock
    List<AlgorithmExecution> listOfTwo = Arrays.asList(execution, execution);
    when(mockStorage.findAll()).thenReturn(listOfTwo);

    // execute
    Collection<ExecutionSummaryRow> actual = api
        .generateSummaryReport();

    // verify
    Assertions.assertEquals(2, actual.size());
  }
}
