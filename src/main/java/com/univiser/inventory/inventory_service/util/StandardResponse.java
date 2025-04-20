package com.univiser.inventory.inventory_service.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StandardResponse {
    private int status;
    private Object data;
    private String message;

}
