package pr.DKEFollowService.repository;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import pr.DKEFollowService.model.User;

import java.util.Collection;

public interface FollowerRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH (f:User)-[r:FOLLOWS]->(u:User) WHERE u.username=$username RETURN f")
    Collection<User> getAllFollowers(@Param("username") String user);
}
