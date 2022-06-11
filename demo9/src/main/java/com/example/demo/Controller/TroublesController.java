package com.example.demo.Controller;

import com.example.demo.DTO.Api;
import com.example.demo.Model.Troubles;
import com.example.demo.Service.TroublesService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/trouble")
@RestController
@RequiredArgsConstructor
public class TroublesController {

    private final TroublesService troublesService;
    Logger log= LoggerFactory.getLogger(TroublesController.class);


    @GetMapping("/getAllTroubles")
    public ResponseEntity <List<Troubles>> getAllTroubles(){
        log.info("get request incoming");
        return ResponseEntity.status(200).body(troublesService.getAllTroubles());
    }
    @PostMapping("/addTroubles")
    public ResponseEntity <Api> addTroubles(
            @RequestBody Troubles troubles){
        log.info("get request incoming");
        troublesService.addTroubles(troubles);
        return ResponseEntity.status(200).body(new Api("Add New Page Problem",200));
    }

    @PostMapping("/addTroublesToUser")
    public ResponseEntity <Api> addTroublesToUser(
            @RequestBody Integer troubleID, @RequestBody Integer userId){
        log.info("get request incoming");
        troublesService.addTroublesToUser(troubleID,userId);
        return ResponseEntity.status(200).body(new Api("Add New Page Problem",200));
    }
}


