package com.example.demo.Controller;

import com.example.demo.DTO.Api;
import com.example.demo.DTO.UserEvaluationDTO;
import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    Logger log= LoggerFactory.getLogger(UserController.class);


    @GetMapping("/getUsers")
    public ResponseEntity <List<User>> getUsers(){
        log.info("get request incoming");
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }
    @PostMapping("/addNewUsers")
    public ResponseEntity <Api> addNewUsers(@RequestBody @Valid User user){
        log.info("get request incoming");
        userService.addNewUsers(user);
        return ResponseEntity.status(200).body(new Api("Add a New User",200));
    }
    @PostMapping("/addServiceToUser")
    public ResponseEntity addServiceToUser(@RequestBody UserEvaluationDTO userEvaluationDTO){
        log.info("get request incoming");
        return ResponseEntity.status(200).body
                (userService.addServiceToUser(userEvaluationDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new Api(message,400));
        }

        userService.addUser(user);
        return ResponseEntity.status(200).body(new Api("New User added",200));
    }

    @GetMapping("/admin")
    public ResponseEntity<?> admin(){
        return ResponseEntity.status(200).body("Hello Admin");
    }

    @GetMapping("/user")
    public ResponseEntity<?> user(){
        return ResponseEntity.status(200).body(new Api("Hello User",200));
    }
}
