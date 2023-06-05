package com.example.happyness.michael.joseph.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="purchase Table")
public class Purchase_order {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name="order_id")
    int order_id;
    @Column(name="order_name")
    String order_name;
    @Column(name="delivery_date")
    String delivery_date;
    @Column(name="billing_address")
    String billing_address;
}
