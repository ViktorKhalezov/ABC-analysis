package ru.gb.modelmodule.unitOfWork;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.stereotype.Component;
import ru.gb.modelmodule.dto.ProductDto;
import ru.gb.modelmodule.mapper.ProductDtoMapper;

import java.util.*;

// Model
@RequiredArgsConstructor
@Component
public class UnitOfWork {

    private final ProductDtoMapper productDtoMapper;

    private final Map<String, List<ProductDto>> identityMap = new HashMap<>();

    private final String INSERT = "INSERT";

    private final String SELECT = "SELECT";

    private final String UPDATE = "UPDATE";

    private final String DELETE = "DELETE";



    public List<ProductDto> readAll() {
        if(identityMap.get(SELECT) == null || identityMap.get(SELECT).size() == 0) {
            identityMap.put(SELECT, productDtoMapper.findAll());
        }
        return identityMap.get(SELECT);
    }

    public ProductDto readOneProduct(Long id) {
        List<ProductDto> productDtos = readAll();
       for(ProductDto productDto : productDtos) {
            if(id == productDto.getId()) {
                return productDto;
            }
       }
       return null;
    }

    public void registerNew(ProductDto productDto) {
        if(identityMap.get(INSERT) == null) {
            identityMap.put(INSERT, new ArrayList<>());
        }
        identityMap.get(INSERT).add(productDto);
    }

    public void registerUpdate(ProductDto productDto) {
        if(identityMap.get(UPDATE) == null) {
            identityMap.put(UPDATE, new ArrayList<>());
        }
        identityMap.get(UPDATE).add(productDto);
    }

    public void registerDelete (ProductDto productDto) {
        if(identityMap.get(DELETE) == null) {
            identityMap.put(DELETE, new ArrayList<>());
        }
        identityMap.get(DELETE).add(productDto);
    }


    public void commit() {
        if(identityMap == null || identityMap.size() == 0) {
            return;
        }

        if(identityMap.containsKey(INSERT)) {
            commitInsert();
        }
        if(identityMap.containsKey(UPDATE)) {
            commitUpdate();
        }
        if(identityMap.containsKey(DELETE)) {
            commitDelete();
        }

            identityMap.put(SELECT, productDtoMapper.findAll());
    }


    private void commitInsert() {
        List<ProductDto> productDtos = identityMap.get(INSERT);
        for(ProductDto productDto : productDtos) {
            productDtoMapper.insert(productDto);
        }

        identityMap.put(INSERT, new ArrayList<>());
    }

    private void commitUpdate() {
        List<ProductDto> productDtos = identityMap.get(UPDATE);
        for(ProductDto productDto : productDtos) {
            productDtoMapper.update(productDto);
        }
        identityMap.put(UPDATE, new ArrayList<>());
    }

    private void commitDelete() {
        List<ProductDto> productDtos = identityMap.get(DELETE);
        for(ProductDto productDto : productDtos) {
            productDtoMapper.delete(productDto);
        }

        identityMap.put(DELETE, new ArrayList<>());
    }

}
