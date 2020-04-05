package org.schhx.tutorial.controller;

import org.schhx.tutorial.dto.CreateUserReq;
import org.schhx.tutorial.dto.UpdateUserReq;
import org.schhx.tutorial.entity.User;
import org.schhx.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author shanchao
 * @date 2020-04-05
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody CreateUserReq req) {
        return userService.create(req.getUsername(), req.getAge());
    }

    @PostMapping("/delete")
    public void deleteUser(@RequestParam String userId) {
        userService.delete(userId);
    }

    @PostMapping("/update")
    public User updateUser(@RequestBody UpdateUserReq req) {
        return userService.update(req.getId(), req.getUsername(), req.getAge());
    }

    @GetMapping("/get")
    public User getUser(@RequestParam String userId) {
        return userService.getById(userId);
    }

}
