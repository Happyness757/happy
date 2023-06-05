package com.example.happyness.michael.joseph.ServiceImpl;

import com.example.happyness.michael.joseph.Entity.Purchase_order;
import com.example.happyness.michael.joseph.Exception.PurchaseException;
import com.example.happyness.michael.joseph.Repository.PurchaseRepository;
import com.example.happyness.michael.joseph.Service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService{
    private PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public Purchase_order addpurchase_order(Purchase_order purchase_order) {
        return purchaseRepository.save(purchase_order);
    }

    @Override
    public List<Purchase_order> getAllPurchase_order() {
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase_order getPurchaseorderById(Long id) {
        Purchase_order purchaseOrder=purchaseRepository.findById(id)
                .orElseThrow(()->new PurchaseException("purchase order not found"));
        return purchaseOrder;
    }


    @Override
    public Purchase_order updatePurchase_order(Long id, Purchase_order purchase_order) {
        Purchase_order existingPurchase_order=purchaseRepository.findById(id)
                .orElseThrow(()->new PurchaseException("purchase order not found"));

        existingPurchase_order.setOrder_id(purchase_order.getOrder_id());
        existingPurchase_order.setOrder_name(purchase_order.getOrder_name());
        existingPurchase_order.setDelivery_date(purchase_order.getDelivery_date());
        existingPurchase_order.setBilling_address(purchase_order.getBilling_address());

        Purchase_order updatePurchase_order=purchaseRepository.save(existingPurchase_order);
        return updatePurchase_order;
    }

    @Override
    public void deletePurchase_orderById(Long id) {
        Purchase_order deletePurchase_order=purchaseRepository.findById(id)
                .orElseThrow(()->new PurchaseException("purchase order not found"));
        purchaseRepository.delete(deletePurchase_order);

    }
}
