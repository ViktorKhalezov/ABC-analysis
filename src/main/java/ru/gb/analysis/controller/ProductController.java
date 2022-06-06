package ru.gb.analysis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.analysis.common.AnalysisRecommendation;
import ru.gb.analysis.dto.ProductDto;
import ru.gb.analysis.dto.ProductWithCategories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.analysis.service.ProductGateway;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


@AllArgsConstructor
@Controller
@RequestMapping("/abc")
public class ProductController {

    private final ProductGateway productGateway;


    @GetMapping
    public String makeAnalysis(Model model) {
        ArrayList<ProductDto> productDtos = (ArrayList<ProductDto>) productGateway.getProductList();
        ArrayList<ProductWithCategories> productsWithCategories = new ArrayList<>();

        for(ProductDto productDto : productDtos) {
            ProductWithCategories productWithCategories = mapProductDtoToProductWithCategories(productDto);
            productsWithCategories.add(productWithCategories);
        }
        setSalesCategory(productsWithCategories);
        setRevenueCategory(productsWithCategories);
        setMarginRateCategory(productsWithCategories);
        setCombinedCategory(productsWithCategories);
        setRecommendation(productsWithCategories);
        model.addAttribute("productsWithCategories", productsWithCategories);
        return "analysis-table";
    }


    private void setSalesCategory(ArrayList<ProductWithCategories> productsWithCategories) {
        Collections.sort(productsWithCategories, new Comparator<ProductWithCategories>() {
            public int compare(ProductWithCategories p1, ProductWithCategories p2) {
                return p2.getSales().compareTo(p1.getSales());
            }
        });
        for(int i = 0; i < productsWithCategories.size(); i++) {
            double doubleI = i;
            if(doubleI / productsWithCategories.size() <= 0.2) {
                productsWithCategories.get(i).setSalesCategory("A");
            } else if(doubleI / productsWithCategories.size() < 0.5) {
                productsWithCategories.get(i).setSalesCategory("B");
            } else {
                productsWithCategories.get(i).setSalesCategory("C");
            }
        }
    }


    private void setRevenueCategory(ArrayList<ProductWithCategories> productsWithCategories) {
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

    private void setMarginRateCategory(ArrayList<ProductWithCategories> productsWithCategories) {
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

    private void setCombinedCategory(ArrayList<ProductWithCategories> productsWithCategories) {
        for(ProductWithCategories productWithCategories : productsWithCategories) {
            productWithCategories.setCombinedCategory(productWithCategories.getSalesCategory() + productWithCategories.getRevenueCategory() + productWithCategories.getMarginRateCategory());
        }
        Collections.sort(productsWithCategories, new Comparator<ProductWithCategories>() {
            public int compare(ProductWithCategories p1, ProductWithCategories p2) {
                return p1.getCombinedCategory().compareTo(p2.getCombinedCategory());
            }
        });
    }

    private void setRecommendation(ArrayList<ProductWithCategories> productsWithCategories) {
        for(ProductWithCategories productWithCategories : productsWithCategories) {
            AnalysisRecommendation recommendation = AnalysisRecommendation.valueOf(productWithCategories.getCombinedCategory());
            productWithCategories.setRecommendation(recommendation);
        }
    }

    private ProductWithCategories mapProductDtoToProductWithCategories(ProductDto productDto) {
        ProductWithCategories productWithCategories = new ProductWithCategories();
        productWithCategories.setId(productDto.getId());
        productWithCategories.setTitle(productDto.getTitle());
        productWithCategories.setSales(productDto.getSales());
        productWithCategories.setRevenue(productDto.getRevenue());
        productWithCategories.setMarginRate(productDto.getMarginRate());
        return productWithCategories;
    }

}

