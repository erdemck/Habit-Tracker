package org.habittracker.backend.Service;

import org.habittracker.backend.Repo.AppUserRepository;
import org.habittracker.backend.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private AppUserRepository UserRepository;

    @Autowired
    public UserService(AppUserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    public AppUser createUser(AppUser user) {
        return UserRepository.create(user);
    }

    public List<AppUser> getAllUsers() {
        return UserRepository.findAll();
    }

    public AppUser findById(Long id) {
        return UserRepository.findById(id);
    }
}

