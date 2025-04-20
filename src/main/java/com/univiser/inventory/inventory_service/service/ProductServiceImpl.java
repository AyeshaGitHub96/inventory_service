package com.univiser.inventory.inventory_service.service;

import com.univiser.inventory.inventory_service.dto.requestDto.RequestProductDto;
import com.univiser.inventory.inventory_service.entity.Product;
import com.univiser.inventory.inventory_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product create(RequestProductDto dto) {
        Product product = new Product();
        product.setProductName(dto.getProductName());
        product.setQuantity(dto.getQuantity());
        product.setPrice(dto.getPrice());
        return repository.save(product);
    }

    public Product update(Integer id, RequestProductDto dto) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setProductName(dto.getProductName());
        product.setQuantity(dto.getQuantity());
        product.setPrice(dto.getPrice());

        return repository.save(product);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
