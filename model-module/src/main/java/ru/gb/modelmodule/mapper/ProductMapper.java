package ru.gb.modelmodule.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.modelmodule.dto.ProductDto;
import ru.gb.modelmodule.entity.Product;

@Mapper
public interface ProductMapper {

    @Mapping(source = "id", target = "id")
    Product toProduct(ProductDto productDto);

    @Mapping(source = "id", target = "id")
    ProductDto toProductDto(Product product);

}
