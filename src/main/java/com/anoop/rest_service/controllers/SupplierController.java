package com.anoop.rest_service.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anoop.rest_service.dto.SupplierDTO;
import com.anoop.rest_service.enums.ManufacturingProcess;
import com.anoop.rest_service.enums.NatureOfBusiness;
import com.anoop.rest_service.services.SupplierService;


@RestController
public class SupplierController {

    private final SupplierService supplierService; 

    public SupplierController(SupplierService supplierService){
        this.supplierService = supplierService; 
    }

    @GetMapping("/suppliers")
    public List<SupplierDTO> getSuppliers(
            @RequestParam String location,
            @RequestParam NatureOfBusiness natureOfBusiness,
            @RequestParam Set<ManufacturingProcess> manufacturingProcesses,
            @RequestParam(defaultValue = "10") int limit) { // Default limit to 10 if not provided

        return supplierService.getSuppliers(location, natureOfBusiness, manufacturingProcesses, limit);
    }

    @PostMapping("/suppliers")
    public ResponseEntity<SupplierDTO> createSupplier(@RequestBody SupplierDTO supplierDTO) {
        SupplierDTO createdSupplier = supplierService.addSupplier(supplierDTO);
        return ResponseEntity.ok(createdSupplier);
    }


}
