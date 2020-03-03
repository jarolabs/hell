package com.jarogoose.hell.performance.execute;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jarogoose.hell.performance.control.message.ExecutionSummaryRowResponse;
import com.jarogoose.hell.performance.persist.data.ConfigurationKey;
import com.jarogoose.hell.performance.persist.data.ConfigurationKey.Position;
import com.jarogoose.hell.performance.persist.data.ConfigurationKey.Type;
import com.jarogoose.hell.performance.persist.data.ExecutionRecord;
import com.jarogoose.hell.performance.persist.data.MeasurementData;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CollectionWorkflowMapperTest {

  @Test()
  @DisplayName("Convert a collection of persisted records into response model")
  void toExecutionSummaryRows_mapsIntoCollectionOfSizeTwo() {
    // init -> set up a record with two measurement records
    ConfigurationKey key = new ConfigurationKey();
    key.setType(Type.ARRAY_LIST);
    key.setPosition(Position.BEGINNING);
    MeasurementData summary = new MeasurementData();
    Collection<MeasurementData> data = Arrays.asList(summary, summary);
    ExecutionRecord record = new ExecutionRecord(key, data);

    // execute
    Collection<ExecutionSummaryRowResponse> actual = CollectionWorkflowMapper
        .toExecutionSummaryRows(Collections.singletonList(record));

    // verify
    assertEquals(2, actual.size());
  }
}
