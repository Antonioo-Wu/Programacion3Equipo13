package com.F1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.F1.repository")
@EnableTransactionManagement
public class Neo4jConfig {
    
    @Bean
    public Driver driver(@Value("${spring.neo4j.uri}") String uri,
                        @Value("${spring.neo4j.authentication.username}") String user,
                        @Value("${spring.neo4j.authentication.password}") String password) {
        return GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }
}
