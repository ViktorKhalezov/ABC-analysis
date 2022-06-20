package ru.gb.modelmodule.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.modelmodule.dto.ProductDto;
import ru.gb.modelmodule.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Model
@Component
public class ProductDtoMapper {

    private final String URL = "jdbc:postgresql://localhost:5432/abc_analysis";
    private final String USER = "geek";
    private final String PASSWORD = "geek";

    private Connection connection;

    public ProductDtoMapper() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ProductDto findById(long id) {
        ProductDto productDto = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT ID, TITLE, SALES, REVENUE, MARGIN_RATE FROM PRODUCT WHERE ID = ?");
            statement.setLong(1, id);
           try(ResultSet resultSet = statement.executeQuery()) {
               while(resultSet.next()) {
                   productDto = new ProductDto();
                   productDto.setId(resultSet.getLong(1));
                   productDto.setTitle(resultSet.getString(2));
                   productDto.setSales(resultSet.getBigDecimal(3));
                   productDto.setRevenue(resultSet.getBigDecimal(4));
                   productDto.setMarginRate(resultSet.getBigDecimal(5));
               }
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDto;
    }


    public List<ProductDto> findAll() {
        List<ProductDto> productDtos = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM PRODUCT");
            try(ResultSet resultSet = statement.executeQuery()) {
                while(resultSet.next()) {
                    ProductDto productDto = new ProductDto();
                    productDto.setId(resultSet.getLong(1));
                    productDto.setTitle(resultSet.getString(2));
                    productDto.setSales(resultSet.getBigDecimal(3));
                    productDto.setRevenue(resultSet.getBigDecimal(4));
                    productDto.setMarginRate(resultSet.getBigDecimal(5));
                    productDtos.add(productDto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDtos;
    }


    public void insert(ProductDto productDto) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO PRODUCT (TITLE, SALES, REVENUE, MARGIN_RATE) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, productDto.getTitle());
            statement.setBigDecimal(2, productDto.getSales());
            statement.setBigDecimal(3, productDto.getRevenue());
            statement.setBigDecimal(4, productDto.getMarginRate());
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    public void update(ProductDto productDto) {
        try(PreparedStatement statement = connection.prepareStatement("UPDATE PRODUCT SET TITLE = 'PC' WHERE ID = ?")) {
            statement.setLong(1, productDto.getId());
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(ProductDto productDto) {
        try(PreparedStatement statement = connection.prepareStatement("DELETE FROM PRODUCT WHERE ID = ?")) {
            statement.setLong(1, productDto.getId());
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

