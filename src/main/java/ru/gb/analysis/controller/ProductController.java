package ru.gb.analysis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.analysis.common.AnalysisRecommendation;
import ru.gb.analysis.dto.ProductDto;
import ru.gb.analysis.dto.ProductWithCategories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.analysis.dto.ProductWithCategoriesBuilder;
import ru.gb.analysis.service.ProductGateway;
import ru.gb.analysis.strategy.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Controller
@AllArgsConstructor
@Controller
@RequestMapping("/abc")
public class ProductController {

    private final ProductGateway productGateway;

    private final StrategyRunner strategyRunner;

    @GetMapping
    public String makeAnalysis(Model model) {
        ArrayList<ProductDto> productDtos = (ArrayList<ProductDto>) productGateway.getProductList();
        ArrayList<ProductWithCategories> productsWithCategories = new ArrayList<>();

        for(ProductDto productDto : productDtos) {
            ProductWithCategories productWithCategories = mapProductDtoToProductWithCategories(productDto);
            productsWithCategories.add(productWithCategories);
        }
        strategyRunner.setStrategy(new SetSalesCategoryStrategy(productsWithCategories));
        strategyRunner.runStrategy();

        strategyRunner.setStrategy(new SetRevenueCategoryStrategy(productsWithCategories));
        strategyRunner.runStrategy();

        strategyRunner.setStrategy(new SetMarginRateCategoryStrategy(productsWithCategories));
        strategyRunner.runStrategy();

        strategyRunner.setStrategy(new SetCombinedCategoryStrategy(productsWithCategories));
        strategyRunner.runStrategy();

        strategyRunner.setStrategy(new SetRecommendationStrategy(productsWithCategories));
        strategyRunner.runStrategy();

        model.addAttribute("productsWithCategories", productsWithCategories);
        return "analysis-table";
    }

    private ProductWithCategories mapProductDtoToProductWithCategories(ProductDto productDto) {
        ProductWithCategories productWithCategories = new ProductWithCategoriesBuilder()
                .id(productDto.getId())
                .title(productDto.getTitle())
                .sales(productDto.getSales())
                .revenue(productDto.getRevenue())
                .marginRate(productDto.getMarginRate())
                .build();
        return productWithCategories;
    }

}

