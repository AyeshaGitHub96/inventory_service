package com.univiser.inventory.inventory_service.service;

import com.univiser.inventory.inventory_service.dto.requestDto.RequestProductDto;
import com.univiser.inventory.inventory_service.entity.Product;


import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product create(RequestProductDto dto);

    Product update(Integer id, RequestProductDto dto);

    void delete(Integer id);
}

