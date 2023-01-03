package com.springproject.inventory_service.controller;

import com.springproject.inventory_service.dto.InventoryResponse;
import com.springproject.inventory_service.repository.InventoryRepository;
import com.springproject.inventory_service.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@AllArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;


//    http://localhost:8082/api/inventory/iphone_13,iphone_13_red,..      <- In case of path variable
//    http://localhost:8082/api/inventory?sku_code=iphone_13&sku_code=iphone_13_red,..      <- In case of request-parameters

    //    @GetMapping("/{sku_code}")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
//    public boolean isInStock(@PathVariable("sku_code") String sku_code){
//    public boolean isInStock(@RequestParam List<String> sku_code){
    public List<InventoryResponse> isInStock(@RequestParam List<String> sku_code){
        return inventoryService.isInStock(sku_code);
    }
}
