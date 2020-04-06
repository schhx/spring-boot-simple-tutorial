package org.schhx.tutorial.controller;

import org.schhx.tutorial.entity.User;
import org.schhx.tutorial.req.CreateUserReq;
import org.schhx.tutorial.req.UpdateUserReq;
import org.schhx.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author schhx
 * @date 2020-04-05
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody @Valid CreateUserReq req) {
        return userService.create(req.getUsername(), req.getAge());
    }

    @PostMapping("/delete")
    public void deleteUser(@NotBlank(message = "userId不能为空") String userId) {
        userService.delete(userId);
    }

    @PostMapping("/update")
    public User updateUser(@RequestBody @Valid UpdateUserReq req) {
        return userService.update(req.getId(), req.getUsername(), req.getAge());
    }

    @GetMapping("/get")
    public User getUser(@NotBlank(message = "userId不能为空") String userId) {
        return userService.getById(userId);
    }

}
