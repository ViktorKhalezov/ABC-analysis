package ru.gb.modelmodule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.modelmodule.dao.ProductDao;
import ru.gb.modelmodule.dto.ProductDto;
import ru.gb.modelmodule.entity.Product;
import ru.gb.modelmodule.mapper.ProductMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;

    private final ProductMapper productMapper;

    @Transactional(readOnly = true)
    public List<ProductDto> findAll() {
        return productDao.findAll().stream().map(productMapper::toProductDto).collect(Collectors.toList());
    }

    @Transactional
    public ProductDto save(ProductDto productDto) {
        Product product = productMapper.toProduct(productDto);
        return productMapper.toProductDto(productDao.save(product));
    }


    public void deleteById(Long id) {
        try {
            productDao.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }

    }

}
