package com.example.demo.Service;

import com.example.demo.DTO.UserEvaluationDTO;
import com.example.demo.Model.ServiceEvaluation;
import com.example.demo.Model.User;
import com.example.demo.Repository.ServiceRepository;
import com.example.demo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceEvaluationService {

    private final ServiceRepository serviceRepository;
    private final UserRepository userRepository;



    public List <ServiceEvaluation> getEvaluation(){
        return serviceRepository.findAll();
    }

    public void addEvaluation(ServiceEvaluation serviceEvaluation) {
        serviceRepository.save(serviceEvaluation);
    }
}
