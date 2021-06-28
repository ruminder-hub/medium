package com.ruminderhub.springboot.redis.controller;

import com.ruminderhub.springboot.redis.model.User;
import com.ruminderhub.springboot.redis.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepo userRepo;
    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        log.info("Received user to be added: {}", user);
        userRepo.save(user);
        return new ResponseEntity<String>("User Saved", HttpStatus.OK);
    }

    @GetMapping(value = "/find/{username}")
    public ResponseEntity<User> findUser(@PathVariable String username) {
        log.info("RequestReceived to find user {}", username);
        User user = userRepo.find(username);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


}
