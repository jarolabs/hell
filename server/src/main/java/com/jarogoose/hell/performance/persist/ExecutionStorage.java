package com.jarogoose.hell.performance.persist;

import com.jarogoose.hell.performance.persist.data.ConfigurationKey;
import com.jarogoose.hell.performance.persist.data.ExecutionTable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecutionStorage extends MongoRepository<ExecutionTable, ConfigurationKey> {
}
