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

    public Collection<User> getAllFollowers(String user) {
        return followerRepository.getAllFollowers(user);
    }

    public Collection<User> getAllUsers() {
        return followerRepository.findAll();
    }
}
