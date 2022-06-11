package com.example.demo.Controller;

import com.example.demo.DTO.Api;
import com.example.demo.DTO.UserEvaluationDTO;
import com.example.demo.Model.ServiceEvaluation;
import com.example.demo.Service.ServiceEvaluationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/Evaluation")
@RestController
@RequiredArgsConstructor
public class ServiceEvaluationController {

    private final ServiceEvaluationService serviceEvaluationService;
    Logger log= LoggerFactory.getLogger(ServiceEvaluationController.class);



    @GetMapping("/getEvaluation")
    public ResponseEntity <List<ServiceEvaluation>> getEvaluation(){
        log.info("get request incoming");
        return ResponseEntity.status(HttpStatus.OK).body(serviceEvaluationService.getEvaluation());
    }
    @PostMapping("/addEvaluation")
    public ResponseEntity <Api> addEvaluation(@RequestBody @Valid ServiceEvaluation serviceEvaluation){
        serviceEvaluationService.addEvaluation(serviceEvaluation);
        log.info("get request incoming");
        return ResponseEntity.status(HttpStatus.OK).body(new Api("Add It Evaluation",200));
    }
}
