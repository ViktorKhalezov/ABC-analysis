package ru.gb.modelmodule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.modelmodule.dao.ProductDao;
import ru.gb.modelmodule.dto.ProductDto;
import ru.gb.modelmodule.entity.Product;
import ru.gb.modelmodule.facade.InterfaceFacade;
import ru.gb.modelmodule.mapper.ProductMapper;
import ru.gb.modelmodule.unitOfWork.UnitOfWork;

import java.util.List;
import java.util.stream.Collectors;

// Model
@Service
@RequiredArgsConstructor
public class ProductService {


    private final UnitOfWork unitOfWork;
//    private final InterfaceFacade interfaceFacade;

    public List<ProductDto> getProducts() {
        return unitOfWork.readAll();
    }

    public ProductDto getProductById(Long id) {
        return unitOfWork.readOneProduct(id);
    }

    public void insert(ProductDto productDto) {
        unitOfWork.registerNew(productDto);
        unitOfWork.commit();
    }

    public void update(ProductDto productDto) {
        unitOfWork.registerUpdate(productDto);
        unitOfWork.commit();
    }

    public void delete(ProductDto productDto) {
        unitOfWork.registerDelete(productDto);
        unitOfWork.commit();
    }

//    public ProductDto save(ProductDto productDto) {
//        return interfaceFacade.save(productDto);
//    }
//
//    public void delete(Long id) {
//        interfaceFacade.deleteById(id);
//    }

}
