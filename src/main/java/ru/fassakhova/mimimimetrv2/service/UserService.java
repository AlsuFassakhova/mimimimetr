package ru.fassakhova.mimimimetrv2.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fassakhova.mimimimetrv2.entity.User;
import ru.fassakhova.mimimimetrv2.entity.dto.UserDTO;
import ru.fassakhova.mimimimetrv2.repository.UserRepository;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User createNewUser(UserDTO userDTO) {
        User user = userRepository.findByNameAndNick(userDTO.getName(), userDTO.getNick());
        if (Objects.isNull(user)) {

            User newUser = new User();
            newUser.setName(userDTO.getName());
            newUser.setNick(userDTO.getNick());
            save(newUser);

            return newUser;
        } else return null;
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
