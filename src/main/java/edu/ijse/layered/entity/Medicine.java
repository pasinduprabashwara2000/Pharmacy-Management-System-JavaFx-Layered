package edu.ijse.layered.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "medicine")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String medicineId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    private double unitPrice;
    private int qtyOnHand;
    private String expireDate;

}
