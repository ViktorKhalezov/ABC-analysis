package ru.gb.analysis.service;

import ru.gb.analysis.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(url = "localhost:8734/analysis", value = "productGateway")
public interface ProductGateway {

    @GetMapping(produces = "application/json;charset=UTF-8")
    List<ProductDto> getProductList();

}
