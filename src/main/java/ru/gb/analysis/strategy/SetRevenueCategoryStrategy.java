package ru.gb.analysis.strategy;

import ru.gb.analysis.dto.ProductWithCategories;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SetRevenueCategoryStrategy implements SetPropertyStrategy {

    private List<ProductWithCategories> productsWithCategories;

    public SetRevenueCategoryStrategy(List<ProductWithCategories> productsWithCategories) {
        this.productsWithCategories = productsWithCategories;
    }

    @Override
    public void setProperty() {
        Collections.sort(productsWithCategories, new Comparator<ProductWithCategories>() {
            public int compare(ProductWithCategories p1, ProductWithCategories p2) {
                return p2.getRevenue().compareTo(p1.getRevenue());
            }
        });
        for(int i = 0; i < productsWithCategories.size(); i++) {
            double doubleI = i;
            if(doubleI / productsWithCategories.size() <= 0.2) {
                productsWithCategories.get(i).setRevenueCategory("A");
            } else if(doubleI / productsWithCategories.size() < 0.5) {
                productsWithCategories.get(i).setRevenueCategory("B");
            } else {
                productsWithCategories.get(i).setRevenueCategory("C");
            }
        }
    }

}
