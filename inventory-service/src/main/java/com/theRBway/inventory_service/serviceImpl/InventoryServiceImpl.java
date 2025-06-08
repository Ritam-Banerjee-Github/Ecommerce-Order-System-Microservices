package com.theRBway.inventory_service.serviceImpl;

import com.theRBway.inventory_service.entity.Inventory;
import com.theRBway.inventory_service.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryServiceImpl {
    @Autowired
    private InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode){
        Optional<Inventory> inventory=inventoryRepository.findBySkuCode(skuCode);
        return inventory.map(i->i.getQuantity()>0).orElse(false);
    }

    public Inventory saveInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }


}
