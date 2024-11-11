package com.F1.repository;

import com.F1.model.Corredor;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorredorRepository extends Neo4jRepository<Corredor, Long> {
}
