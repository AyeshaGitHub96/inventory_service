package com.univiser.inventory.inventory_service.api;

import com.univiser.inventory.inventory_service.dto.requestDto.RequestProductDto;
import com.univiser.inventory.inventory_service.dto.responseDto.ResponseProductDto;
import com.univiser.inventory.inventory_service.entity.Product;
import com.univiser.inventory.inventory_service.service.ProductService;
import com.univiser.inventory.inventory_service.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<StandardResponse> getAll() {
        List<ResponseProductDto> products = productService.getAll()
                .stream()
                .map(p -> new ResponseProductDto(
                        p.getId(),
                        p.getProductName(),
                        p.getQuantity(),
                        p.getPrice()))
                .toList();
        return ResponseEntity.ok(
                new StandardResponse(200, products, "Product list retrieved")
        );

    }

    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestProductDto dto) {
        Product saved = productService.create(dto);
        ResponseProductDto response = new ResponseProductDto(
                saved.getId(), saved.getProductName(), saved.getQuantity(), saved.getPrice()
        );

        return new ResponseEntity<>(
                new StandardResponse(201, response, "Product created"),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StandardResponse> update(@RequestBody RequestProductDto dto, @PathVariable Integer id) {
        Product updated = productService.update(id, dto);
        ResponseProductDto response = new ResponseProductDto(
                updated.getId(), updated.getProductName(), updated.getQuantity(), updated.getPrice()
        );

        return new ResponseEntity<>(
                new StandardResponse(200, response, "Product updated"),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable Integer id) {
        productService.delete(id);
        return new ResponseEntity<>(
                new StandardResponse(200, null, "Product deleted"),
                HttpStatus.OK
        );
    }
}
