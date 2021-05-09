package pr.DKEFollowService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pr.DKEFollowService.model.User;
import pr.DKEFollowService.service.FollowerService;

import java.util.Collection;
import java.util.List;

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
    @GetMapping("/getFollowedUsers")
    public Collection<User> getAllFollowedUsers(@RequestParam(value = "user") String user) {
        return followerService.getAllFollowedUsers(user);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllUsers")
    public Collection<User> getAllUsers() {
        return followerService.getAllUsers();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/newUser")
    public void createNewUser(@RequestBody User newUser){
        System.out.println("creating new user");
        followerService.createNewUser(newUser);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addRelationship")
    public void addFollowRelationship(@RequestBody User[] users){
        System.out.println("adding relationship");
        followerService.addFollowRelationship(users);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/removeRelationship")
    public void removeFollowRelationship(@RequestBody User[] users){
        System.out.println("removing relationship");
        followerService.removeFollowRelationship(users);
    }
}
