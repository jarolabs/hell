package com.jarogoose.hell.performance.persist;

import com.jarogoose.hell.performance.persist.data.MeasureSummary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasureSummaryStorage extends MongoRepository<MeasureSummary, Long> {

}
