package com.example.happyness.michael.joseph.Repository;

import com.example.happyness.michael.joseph.Entity.Purchase_order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase_order, Long> {
}
