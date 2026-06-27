package edu.ijse.layered.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicineDTO {

    private String medicineId;
    private String name;
    private String category;
    private double unitPrice;
    private int qtyOnHand;
    private String expireDate;

}
