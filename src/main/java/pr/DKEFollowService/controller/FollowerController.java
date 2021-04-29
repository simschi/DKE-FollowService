package pr.DKEFollowService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pr.DKEFollowService.model.User;
import pr.DKEFollowService.service.FollowerService;

import java.util.Collection;

@RestController
@RequestMapping("followservice")
public class FollowerController {
    @Autowired
    FollowerService followerService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getFollowers")
    public Collection<User> getAllFollowers(@RequestParam(value = "user") String user) {
        return followerService.getAllFollowers(user);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllUsers")
    public Collection<User> getAllUsers() {
        return followerService.getAllUsers();
    }
}
