package ru.fassakhova.mimimimetrv2.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fassakhova.mimimimetrv2.entity.User;
import ru.fassakhova.mimimimetrv2.repository.UserRepository;

import java.util.List;
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User createNewUser(String name) {
        User user = new User();
        user.setName(name);

        userRepository.save(user);
        System.out.println("юзер сохранен");
        return user;
    }

    public void save(User user){
        userRepository.save(user);
    }
}
