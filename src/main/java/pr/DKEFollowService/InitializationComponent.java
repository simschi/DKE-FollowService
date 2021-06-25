package pr.DKEFollowService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pr.DKEFollowService.model.User;
import pr.DKEFollowService.repository.FollowerRepository;

import javax.annotation.PostConstruct;

@Component
public class InitializationComponent {

    @Autowired
    private FollowerRepository followerRepository;

    @PostConstruct
    private void init() {
        User user1 = new User();
        user1.setUsername("Batman");

        User user2 = new User();
        user2.setUsername("Spiderman");

        if(!followerRepository.existsByUsername(user1.getUsername())){
            followerRepository.save(user1);
        }

        if(!followerRepository.existsByUsername(user2.getUsername())) {
            followerRepository.save(user2);
        }
    }
}
