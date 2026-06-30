package edu.ijse.layered.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailsDTO {

    private int orderDetailsId;
    private int orderId;
    private int medicineId;
    private int qty;
    private double unitPrice;

}
