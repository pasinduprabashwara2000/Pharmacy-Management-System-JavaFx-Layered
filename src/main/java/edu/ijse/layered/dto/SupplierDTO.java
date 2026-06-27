package edu.ijse.layered.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SupplierDTO {

    private int supplierId;
    private String supplierName;
    private String email;
    private String contactNo;

}
