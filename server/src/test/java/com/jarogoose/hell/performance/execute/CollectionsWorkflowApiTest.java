package com.jarogoose.hell.performance.execute;

import com.jarogoose.hell.performance.persist.ExecutionStorage;
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
    // verify
  }
}
