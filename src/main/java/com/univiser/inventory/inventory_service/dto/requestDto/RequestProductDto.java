package com.univiser.inventory.inventory_service.dto.requestDto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RequestProductDto {
    private String productName;
    private Integer quantity;
    private Double price;

}
