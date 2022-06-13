package ru.gb.analysis.strategy;

import ru.gb.analysis.dto.ProductWithCategories;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SetCombinedCategoryStrategy implements SetPropertyStrategy {

    private List<ProductWithCategories> productsWithCategories;

    public SetCombinedCategoryStrategy(List<ProductWithCategories> productsWithCategories) {
        this.productsWithCategories = productsWithCategories;
    }

    @Override
    public void setProperty() {
        for(ProductWithCategories productWithCategories : productsWithCategories) {
            productWithCategories.setCombinedCategory(productWithCategories.getSalesCategory() + productWithCategories.getRevenueCategory() + productWithCategories.getMarginRateCategory());
        }
        Collections.sort(productsWithCategories, new Comparator<ProductWithCategories>() {
            public int compare(ProductWithCategories p1, ProductWithCategories p2) {
                return p1.getCombinedCategory().compareTo(p2.getCombinedCategory());
            }
        });
    }

}
