package com.example.demo.Service;

import com.example.demo.DTO.UserEvaluationDTO;
import com.example.demo.Exception.InvalidException;
import com.example.demo.Model.ServiceEvaluation;
import com.example.demo.Model.User;
import com.example.demo.Repository.ServiceRepository;
import com.example.demo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ServiceRepository serviceRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUsers(User user) {
        userRepository.save(user);
    }

    public Object addServiceToUser(UserEvaluationDTO userEvaluationDTO) {
        User user = userRepository.findById(userEvaluationDTO.getUserId()).
                orElseThrow(()-> new InvalidException("user id is invalid"));

        ServiceEvaluation serviceEvaluation = new ServiceEvaluation(null,userEvaluationDTO.getMessage(),user);
        user.setServiceEvaluation(serviceEvaluation);
        serviceRepository.save(serviceEvaluation);
        return serviceRepository.findAll();
    }

    public void addUser(User user) {
        String hashedPassword=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }
}
