package pr.DKEFollowService.repository;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import pr.DKEFollowService.model.User;

import java.util.Collection;

public interface FollowerRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH (f:User)-[r:FOLLOWS]->(u:User) WHERE u.email= $email RETURN f")
    Collection<User> getAllFollowers(@Param("email") String user);

    @Query("MATCH (u:User)-[r:FOLLOWS]->(f:User) WHERE u.email= $email RETURN f")
    Collection<User> getAllFollowedUsers(@Param("email") String user);

    @Query("MATCH (a:User), (b:User) WHERE a.email = $fromUser AND b.email = $toUser CREATE (a)-[r:FOLLOWS]->(b)")
    void addFollowRelationship(@Param("fromUser") String fromUserEmail,
                               @Param("toUser") String toUserEmail);

    @Query("MATCH (a:User)-[f:FOLLOWS]->(b:User) WHERE a.email = $fromUser AND b.email = $toUser DELETE f")
    void removeFollowRelationship(@Param("fromUser") String fromUserEmail,
                                  @Param("toUser") String toUserEmail);
}
