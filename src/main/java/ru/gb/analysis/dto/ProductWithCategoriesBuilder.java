package ru.gb.analysis.dto;

import ru.gb.analysis.common.AnalysisRecommendation;
import ru.gb.analysis.factory.ProductFactory;
import ru.gb.analysis.factory.ProductType;

import java.math.BigDecimal;

public class ProductWithCategoriesBuilder {


    private final ProductFactory productFactory;

    private final ProductWithCategories productWithCategories;


    public ProductWithCategoriesBuilder() {
        this.productFactory = new ProductFactory();
        this.productWithCategories = (ProductWithCategories) productFactory.createProduct(ProductType.PRODUCT_WITH_CATEGORIES);
    }

    public ProductWithCategoriesBuilder id(Long id) {
        productWithCategories.setId(id);
        return this;
    }

    public ProductWithCategoriesBuilder title(String title) {
        productWithCategories.setTitle(title);
        return this;
    }

    public ProductWithCategoriesBuilder sales(BigDecimal sales) {
        productWithCategories.setSales(sales);
        return this;
    }

    public ProductWithCategoriesBuilder revenue(BigDecimal revenue) {
        productWithCategories.setRevenue(revenue);
        return this;
    }

    public ProductWithCategoriesBuilder marginRate(BigDecimal marginRate) {
        productWithCategories.setMarginRate(marginRate);
        return this;
    }

    public ProductWithCategoriesBuilder salesCategory(String salesCategory) {
        productWithCategories.setSalesCategory(salesCategory);
        return this;
    }

    public ProductWithCategoriesBuilder revenueCategory(String revenueCategory) {
        productWithCategories.setRevenueCategory(revenueCategory);
        return this;
    }

    public ProductWithCategoriesBuilder marginRateCategory(String marginRateCategory) {
        productWithCategories.setMarginRateCategory(marginRateCategory);
        return this;
    }

    public ProductWithCategoriesBuilder combinedCategory(String combinedCategory) {
        productWithCategories.setCombinedCategory(combinedCategory);
        return this;
    }

    public ProductWithCategoriesBuilder recommendation(AnalysisRecommendation recommendation) {
        productWithCategories.setRecommendation(recommendation);
        return this;
    }

    public ProductWithCategories build() {
        return productWithCategories;
    }

}
