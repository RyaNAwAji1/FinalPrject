package com.example.demo.Controller;

import com.example.demo.DTO.Api;
import com.example.demo.Model.Invoice;
import com.example.demo.Service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/totalPrice")
public class InvoiceController {

    private final InvoiceService invoiceService;
    Logger log= LoggerFactory.getLogger(InvoiceController.class);



    @GetMapping("/getAllTotalPrice")
    public ResponseEntity <List<Invoice>> getAllTotalPrice(){
        log.info("get request incoming");
        return ResponseEntity.status(200).body
                (invoiceService.getAllTotalPrice());
    }
    @PostMapping("/addNewTotalPrice")
    public ResponseEntity <Api> addNewTotalPrice(@RequestBody Invoice invoice){
        log.info("get request incoming");
        invoiceService.addNewTotalPrice(invoice);
        return ResponseEntity.status(HttpStatus.OK).body
                (new Api("Add It New Total Price ",200));

    }
    @PostMapping("/addInvoice")
    public ResponseEntity <Api> addInvoice(
            @RequestParam Integer companyID,@RequestParam Integer invoiceID){
        log.info("get request incoming");
        invoiceService.addInvoice(companyID,invoiceID);
        return ResponseEntity.status(HttpStatus.OK).body
                (new Api("Add It New Total Price ",200));
    }
    @PostMapping("/addUserToInvoice")
    public ResponseEntity <Api> addUserToInvoice(
            @RequestBody Integer invoiceID, @RequestBody Integer userID){
        log.info("get request incoming");
        invoiceService.addInvoice(invoiceID, userID);
        return ResponseEntity.status(HttpStatus.OK).body
                (new Api("Add It New Total Price ",200));


    }
}
