package ru.gb.modelmodule.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long id;

    private String title;

    private BigDecimal sales;

    private BigDecimal revenue;

    private BigDecimal marginRate;


}
