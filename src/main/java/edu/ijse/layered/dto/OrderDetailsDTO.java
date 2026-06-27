package edu.ijse.layered.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailsDTO {

    private String orderId;
    private String medicineId;
    private int qty;
    private double unitPrice;

}
