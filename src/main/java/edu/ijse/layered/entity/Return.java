package edu.ijse.layered.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "return")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Return {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int returnId;

    @OneToOne
    private Order order;

    @OneToOne
    private Customer customer;

    private String returnDate;
    private double totalRefund;

}
