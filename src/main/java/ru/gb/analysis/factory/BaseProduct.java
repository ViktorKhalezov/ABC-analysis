package ru.gb.analysis.factory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseProduct {

    private Long id;

    private String title;

    private BigDecimal sales;

    private BigDecimal revenue;

    private BigDecimal marginRate;

}
