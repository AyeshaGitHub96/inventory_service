package com.univiser.inventory.inventory_service.dto.responseDto;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseProductDto {
    private Integer id;
    private String productName;
    private Integer quantity;
    private Double price;

}

