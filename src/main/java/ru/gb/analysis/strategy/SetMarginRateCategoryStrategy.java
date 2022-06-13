package ru.gb.analysis.strategy;

import ru.gb.analysis.dto.ProductWithCategories;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SetMarginRateCategoryStrategy implements SetPropertyStrategy {

    private List<ProductWithCategories> productsWithCategories;

    public SetMarginRateCategoryStrategy(List<ProductWithCategories> productsWithCategories) {
        this.productsWithCategories = productsWithCategories;
    }

    @Override
    public void setProperty() {
        Collections.sort(productsWithCategories, new Comparator<ProductWithCategories>() {
            public int compare(ProductWithCategories p1, ProductWithCategories p2) {
                return p2.getMarginRate().compareTo(p1.getMarginRate());
            }
        });
        for(int i = 0; i < productsWithCategories.size(); i++) {
            double doubleI = i;
            if(doubleI / productsWithCategories.size() <= 0.2) {
                productsWithCategories.get(i).setMarginRateCategory("A");
            } else if(doubleI / productsWithCategories.size() < 0.5) {
                productsWithCategories.get(i).setMarginRateCategory("B");
            } else {
                productsWithCategories.get(i).setMarginRateCategory("C");
            }
        }
    }

}
