package edu.ijse.layered.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "supplier")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplierId;

    private String supplierName;
    private String email;
    private String contactNo;

    @OneToMany(mappedBy = "supplier")
    List<Medicine> medicines;

}
