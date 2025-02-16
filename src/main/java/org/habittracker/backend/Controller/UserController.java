package org.habittracker.backend.Controller;

import org.habittracker.backend.Service.UserService;
import org.habittracker.backend.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<AppUser> getAllUser() {
        return userService.getAllUsers();
    }

    @PostMapping()
    public AppUser createUser(@RequestBody AppUser appUser) {
        return userService.createUser(appUser);
    }

    @GetMapping("/{id}")
    public AppUser getAppUserById(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public AppUser updateAppUser(@RequestBody AppUser appUser) {
        return userService.updateUser(appUser);
    }

    @DeleteMapping("/{id}")
    public void deleteAppUser(@PathVariable AppUser appUser) {
        userService.deleteUser(appUser);
    }
}
