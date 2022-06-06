package ru.gb.modelmodule.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.modelmodule.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

}
