package com.example.happyness.michael.joseph.Controller;

import com.example.happyness.michael.joseph.Entity.Purchase_order;
import com.example.happyness.michael.joseph.Service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("h/Purchase Table")
public class PurchaseController {
    private PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }
    //add purchase order
    @PostMapping
    public ResponseEntity<Purchase_order> addPurchase_order(@RequestBody Purchase_order purchase_order){
        Purchase_order add=purchaseService.addpurchase_order(purchase_order);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }
    //get all purchase order
    @GetMapping
    public List<Purchase_order>getAllPurchase_order(){
        return purchaseService.getAllPurchase_order();
    }
    //get purchase order by id
    @GetMapping("{id}")
    public ResponseEntity<Purchase_order>getPurchase_orderById(Long id){
        return new ResponseEntity<>(purchaseService.getPurchaseorderById(id), HttpStatus.OK);
    }
    //update by id
    @PutMapping("{id}")
    public ResponseEntity<Purchase_order>update(@PathVariable Long id, @RequestBody Purchase_order purchaseOrder){
        return new ResponseEntity<>(purchaseService.updatePurchase_order(id, purchaseOrder), HttpStatus.OK);


    }
    //delete
    @DeleteMapping("{id}")
    public ResponseEntity<String>deletePurchase_order(@PathVariable Long id){
        purchaseService.deletePurchase_orderById(id);
        return new ResponseEntity<>("Purchase_order deleted", HttpStatus.OK);
    }




}
