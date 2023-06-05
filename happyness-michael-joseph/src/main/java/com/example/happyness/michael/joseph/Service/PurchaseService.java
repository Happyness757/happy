package com.example.happyness.michael.joseph.Service;

import com.example.happyness.michael.joseph.Entity.Purchase_order;

import java.util.List;

public interface PurchaseService {
    //create purchase_order
    Purchase_order addpurchase_order(Purchase_order purchase_order);

     //get all purchase_order
    List<Purchase_order> getAllPurchase_order();

    //get purchase_order by id
    Purchase_order getPurchaseorderById(Long id);

    //update purchase_order
    Purchase_order updatePurchase_order(Long id, Purchase_order purchase_order);

    //delete purchase_order
    void deletePurchase_orderById(Long id);
}
