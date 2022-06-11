package com.example.demo.Service;

import com.example.demo.DTO.TroublesToUserDTO;
import com.example.demo.Model.Troubles;
import com.example.demo.Model.User;
import com.example.demo.Repository.TroublesRepository;
import com.example.demo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TroublesService {

    private final TroublesRepository troublesRepository;
    private final UserRepository userRepository;


    public List<Troubles> getAllTroubles() {
        return troublesRepository.findAll();
    }

    public void addTroubles(Troubles troubles) {
        troublesRepository.save(troubles);
    }
    public void addTroublesToUser(Integer troubleID, Integer userId){

        Troubles troubles= troublesRepository.findById(troubleID).get();
        User user= userRepository.findById(userId).get();

        troubles.setTroubleID(userId);
        troublesRepository.save(troubles);

        user.getTroubles().add(troubles);
        userRepository.save(user);
    }
}
