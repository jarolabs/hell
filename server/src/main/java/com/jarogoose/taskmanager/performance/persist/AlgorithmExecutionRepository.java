package com.jarogoose.taskmanager.performance.persist;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlgorithmExecutionRepository extends MongoRepository<AlgorithmExecution, Long> {

}
