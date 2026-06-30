package edu.ijse.layered.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicineDTO {

    private int medicineId;
    private String name;
    private int categoryId;
    private int supplierId;
    private double unitPrice;
    private int qtyOnHand;
    private LocalDate expireDate;

}
