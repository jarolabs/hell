package com.jarogoose.hell.performance.persist;

import com.jarogoose.hell.performance.persist.data.ExecutionConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecutionConfigurationStorage extends MongoRepository<ExecutionConfiguration, Long> {

}
