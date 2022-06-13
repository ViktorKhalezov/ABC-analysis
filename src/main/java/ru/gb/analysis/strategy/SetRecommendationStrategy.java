package ru.gb.analysis.strategy;

import ru.gb.analysis.common.AnalysisRecommendation;
import ru.gb.analysis.dto.ProductWithCategories;

import java.util.List;

public class SetRecommendationStrategy implements SetPropertyStrategy {

    private List<ProductWithCategories> productsWithCategories;

    public SetRecommendationStrategy(List<ProductWithCategories> productsWithCategories) {
        this.productsWithCategories = productsWithCategories;
    }

    @Override
    public void setProperty() {
        for(ProductWithCategories productWithCategories : productsWithCategories) {
            AnalysisRecommendation recommendation = AnalysisRecommendation.valueOf(productWithCategories.getCombinedCategory());
            productWithCategories.setRecommendation(recommendation);
        }
    }

}
