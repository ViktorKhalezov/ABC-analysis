package ru.gb.analysis.dto;

import ru.gb.analysis.common.AnalysisRecommendation;
import lombok.*;
import ru.gb.analysis.factory.BaseProduct;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class ProductWithCategories extends BaseProduct {

    private String salesCategory;

    private String revenueCategory;

    private String marginRateCategory;

    private String combinedCategory;

    private AnalysisRecommendation recommendation;

}
