package com.jarogoose.hell.performance.persist;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlgorithmExecutionRepository extends MongoRepository<ExecutionConfiguration, Long> {

}
