package ru.gb.modelmodule.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.modelmodule.service.ProductService;
import ru.gb.modelmodule.dto.ProductDto;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/analysis")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getProductList() {
       return productService.getProducts();
    }


}
