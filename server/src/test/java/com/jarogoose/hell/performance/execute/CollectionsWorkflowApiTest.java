package com.jarogoose.hell.performance.execute;

import com.jarogoose.hell.performance.control.message.WorkflowConfigurationRequest;
import com.jarogoose.hell.performance.persist.ExecutionStorage;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CollectionsWorkflowApiTest {

  private CollectionsWorkflowApi api;

  @Mock
  ExecutionStorage mockStorage;

  @BeforeEach
  void beforeAll() {
    MockitoAnnotations.initMocks(this);
    api = new CollectionsWorkflowApi(mockStorage, Executors.newSingleThreadExecutor());
  }

  @Test()
  @DisplayName("")
  void test() {
    // init
    // mock
    // execute
    api.measurePerformance(WorkflowConfigurationRequest.builder().build());
    // verify
    Assertions.assertTrue(true);
  }
}
