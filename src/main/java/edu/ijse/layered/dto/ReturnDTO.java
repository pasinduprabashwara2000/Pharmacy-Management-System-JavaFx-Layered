package edu.ijse.layered.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReturnDTO {

    private String returnId;
    private String orderId;
    private String customerId;
    private String returnDate;
    private double totalRefund;

}
