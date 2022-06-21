package ru.gb.modelmodule.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.modelmodule.dao.ProductDao;
import ru.gb.modelmodule.dto.ProductDto;
import ru.gb.modelmodule.entity.Product;
import ru.gb.modelmodule.mapper.ProductMapper;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
// Антипаттерн "Полтергейст" - после того, как прилжожение было перенесено с JPA на JDBC данный код стал не нужен (он нигде больше не используется)
public class InterfaceFacade {

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
