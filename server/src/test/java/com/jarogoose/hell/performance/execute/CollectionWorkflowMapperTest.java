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
import java.util.List;
import org.junit.jupiter.api.Test;

class CollectionWorkflowMapperTest {

  @Test()
  void mapsIntoCollectionOfSizeTwo() {
    // Scenario -> one record multiple summaries:
    //  - define one configuration key with any data
    //  - define two summaries with any data
    //  - associate given key with summaries as one record
    //  - map given record execution summary row
    //  - verify there are two execution summary rows

    // init
    ConfigurationKey key = new ConfigurationKey();
    key.setType(Type.ARRAY_LIST);
    key.setPosition(Position.BEGINNING);
    MeasurementData summary = new MeasurementData();
    Collection<MeasurementData> data = Arrays.asList(summary, summary);
    ExecutionRecord record = new ExecutionRecord(key, data);

    // execute
    List<ExecutionRecord> records = Collections.singletonList(record);
    Collection<ExecutionSummaryRowResponse> actual = CollectionWorkflowMapper
        .toExecutionSummaryRows(records);

    // verify
    assertEquals(2, actual.size());
  }
}
