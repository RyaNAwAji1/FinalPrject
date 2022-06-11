package com.example.demo.Controller;

import com.example.demo.DTO.Api;
import com.example.demo.Model.Product;
import com.example.demo.Service.ProductService;
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
@RequestMapping("api/v1/product")
public class ProductController {

    private final ProductService productService;
    Logger log= LoggerFactory.getLogger(ProductController.class);



    @GetMapping("/getAllProducts")
    public ResponseEntity <List<Product>> getAllProducts(){
        log.info("get request incoming");
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }
    @PostMapping("/addProduct")
    public ResponseEntity <Api> addProduct(@RequestBody @Valid Product product){
        log.info("get request incoming");
        productService.addProduct(product);
        return ResponseEntity.status(200).body(new Api("Add It New Product",200));
    }

}
