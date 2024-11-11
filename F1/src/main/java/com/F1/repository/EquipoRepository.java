package com.F1.repository;

import com.F1.model.Equipo;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EquipoRepository extends Neo4jRepository<Equipo, Long> {
    
    @Query("MATCH (e:Equipo) RETURN e ORDER BY e.nombre")
    List<Equipo> findAllEquipos();
    
    @Query("MATCH (e:Equipo)-[r:ES_RIVAL_DE]->(rival:Equipo) " +
           "RETURN e, collect(r), collect(rival)")
    List<Equipo> findAllWithRivales();
    
    @Query("MATCH (e:Equipo) " +
           "WHERE id(e) = $equipoId " +
           "OPTIONAL MATCH (e)-[r:ES_RIVAL_DE]->(rival:Equipo) " +
           "WITH e, collect(rival) as rivales " +
           "RETURN e, rivales")
    Equipo findEquipoWithRivales(Long equipoId);
}
