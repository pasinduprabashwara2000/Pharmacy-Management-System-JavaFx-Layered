package edu.ijse.layered.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReturnDTO {

    private int returnId;
    private int orderId;
    private int customerId;
    private String returnDate;
    private double totalRefund;

}
