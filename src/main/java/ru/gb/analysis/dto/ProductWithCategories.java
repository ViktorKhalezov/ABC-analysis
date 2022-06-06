package ru.gb.analysis.dto;

import ru.gb.analysis.common.AnalysisRecommendation;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class ProductWithCategories extends ProductDto {

    private String salesCategory;

    private String revenueCategory;

    private String marginRateCategory;

    private String combinedCategory;

    private AnalysisRecommendation recommendation;

}
