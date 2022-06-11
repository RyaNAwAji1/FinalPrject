package com.example.demo.Controller;

import com.example.demo.DTO.Api;
import com.example.demo.DTO.CompanyDTO;
import com.example.demo.DTO.InvoiceTotalPriceDTO;
import com.example.demo.DTO.ProductAddToCompanyDTO;
import com.example.demo.Model.Company;
import com.example.demo.Service.CompanyService;
import com.example.demo.Service.InvoiceService;
import com.example.demo.Service.ProductService;
import com.example.demo.Service.TroublesService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/company")
public class CompanyController {

    private final CompanyService companyService;
    private final ProductService productService;
    private final TroublesService troublesService;
    private final InvoiceService invoiceService;

    Logger log= LoggerFactory.getLogger(CompanyController.class);



    @GetMapping("/getCompanyInfo")
    public ResponseEntity <List<Company>> getCompanyInfo(){
        log.info("get request incoming");
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getCompanyInfo());
    }

    @PostMapping ("/addPrice")
    public ResponseEntity <Api> addPrice(@RequestBody @Valid Company company){
        log.info("get request incoming");
        companyService.addPrice(company);
        return ResponseEntity.status(HttpStatus.OK).body(new Api("Add It ",200));
    }
    @PostMapping("/problemsDetails")
    public ResponseEntity addProblemToCompany(@RequestBody CompanyDTO companyDTO){
       log.info("get request incoming");
        return ResponseEntity.status(200).body(companyService.addProblemToCompany(companyDTO));

    }

    @PostMapping("/AddInvoice")
    public ResponseEntity getTotalPrice(@RequestBody InvoiceTotalPriceDTO invoiceTotalPriceDTO){
        log.info("get request incoming");
        return ResponseEntity.status(200).body(companyService.getTotalPrice(invoiceTotalPriceDTO));

    }
    @PostMapping("/AddProduct")
    public ResponseEntity addProductToCompany(@RequestBody ProductAddToCompanyDTO productAddToCompanyDTO){
        log.info("get request incoming");
        return ResponseEntity.status(200).body(companyService.addProductToCompany(productAddToCompanyDTO));
    }
}
