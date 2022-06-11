package ru.gb.analysis.factory;

import ru.gb.analysis.dto.ProductDto;
import ru.gb.analysis.dto.ProductWithCategories;

public class ProductFactory {

    public BaseProduct createProduct(ProductType productType) {
        BaseProduct product = null;
        switch(productType) {
            case PRODUCT_DTO:
                product = new ProductDto();
                break;
            case PRODUCT_WITH_CATEGORIES:
                product = new ProductWithCategories();
                break;
        }
        return product;
    }

}
