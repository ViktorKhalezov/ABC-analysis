package ru.gb.modelmodule.entity;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product")
// Антипаттерн "Полтергейст" - после того, как прилжожение было перенесено с JPA на JDBC данный код стал не нужен (он нигде больше не используется)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "sales")
    private BigDecimal sales;

    @Column(name = "revenue")
    private BigDecimal revenue;

    @Column(name = "margin_rate")
    private BigDecimal marginRate;


}
