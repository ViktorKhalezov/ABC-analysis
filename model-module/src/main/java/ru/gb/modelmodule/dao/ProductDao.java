package ru.gb.modelmodule.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.modelmodule.entity.Product;

// Антипаттерн "Полтергейст" - после того, как прилжожение было перенесено с JPA на JDBC данный код стал не нужен (он нигде больше не используется)
public interface ProductDao extends JpaRepository<Product, Long> {

}
