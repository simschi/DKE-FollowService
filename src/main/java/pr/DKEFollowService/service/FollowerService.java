package pr.DKEFollowService.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pr.DKEFollowService.model.User;
import pr.DKEFollowService.repository.FollowerRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class FollowerService {
    @Autowired
    FollowerRepository followerRepository;

    public Collection<User> getAllFollowers(String email) {
        return followerRepository.getAllFollowers(email);
    }

    public Collection<User> getAllFollowedUsers(String email) {
        return followerRepository.getAllFollowedUsers(email);
    }

    public Collection<User> getAllUsers() {
        return followerRepository.findAll();
    }

    public void createNewUser(User newUser) {
        followerRepository.save(newUser);
    }

    public void addFollowRelationship(User[] users) {
        User fromUser = users[0];
        User toUser = users[1];
        followerRepository.addFollowRelationship(fromUser.getEmail(), toUser.getEmail());
    }

    public void removeFollowRelationship(User[] users) {
        User fromUser = users[0];
        User toUser = users[1];
        followerRepository.removeFollowRelationship(fromUser.getEmail(), toUser.getEmail());
    }
}
