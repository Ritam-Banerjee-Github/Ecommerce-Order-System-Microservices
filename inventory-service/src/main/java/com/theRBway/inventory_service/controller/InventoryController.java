package com.theRBway.inventory_service.controller;

import com.theRBway.inventory_service.entity.Inventory;
import com.theRBway.inventory_service.serviceImpl.InventoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryServiceImpl inventoryServiceImpl;

    @PostMapping
    public Inventory saveNewInventory(@RequestBody Inventory inventory) {
        return inventoryServiceImpl.saveInventory(inventory);
    }

    @GetMapping("/checkStock/{skuCode}")
    public boolean checkInStock(@PathVariable String skuCode){
        return inventoryServiceImpl.isInStock(skuCode);
    }
}
