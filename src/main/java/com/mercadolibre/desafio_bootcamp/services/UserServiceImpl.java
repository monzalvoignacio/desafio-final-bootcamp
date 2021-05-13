package com.mercadolibre.desafio_bootcamp.services;

import com.mercadolibre.desafio_bootcamp.dto.responses.BasicResponseDto;
import com.mercadolibre.desafio_bootcamp.exceptions.ApiException;
import com.mercadolibre.desafio_bootcamp.models.User;
import com.mercadolibre.desafio_bootcamp.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements com.mercadolibre.desafio_bootcamp.services.UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public BasicResponseDto createUser(String username, String password) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (username.isEmpty() || password.isEmpty()){
            throw new ApiException(HttpStatus.BAD_REQUEST.name(), "Credentials can't be empty", HttpStatus.BAD_REQUEST.value());
        }
        if(userRepository.existsByUsername(username))
            throw new ApiException(HttpStatus.BAD_REQUEST.name(), "Username already exists", HttpStatus.BAD_REQUEST.value());
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(encoder.encode(password));
        newUser.setRole("REGULAR");
        userRepository.save(newUser);
        return new BasicResponseDto(HttpStatus.OK, "User created");
    }

    @Override
    public BasicResponseDto changeRole(String username, String currentUser) throws Exception {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw  new ApiException
                    (HttpStatus.BAD_REQUEST.name(), "User doesn't exist", HttpStatus.BAD_REQUEST.value());
        }
        if (!userRepository.findByUsername(currentUser).getRole().equals("ADMIN")){
            throw  new ApiException
                    (HttpStatus.BAD_REQUEST.name(), "Only admins can change roles", HttpStatus.BAD_REQUEST.value());
        }
        String currentRole = user.getRole();
        String nextRole = currentRole.equals("REGULAR") ? "ADMIN" :  "REGULAR";
        user.setRole(nextRole);
        userRepository.save(user);
        return new BasicResponseDto(HttpStatus.OK, String.format("User %s switched to role %s", username,nextRole));
    }
}
