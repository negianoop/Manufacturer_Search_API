package com.anoop.rest_service.services;

import com.anoop.rest_service.dto.SupplierDTO;
import com.anoop.rest_service.entities.SupplierEntity;
import com.anoop.rest_service.enums.ManufacturingProcess;
import com.anoop.rest_service.enums.NatureOfBusiness;
import com.anoop.rest_service.repositories.SupplierRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public SupplierDTO addSupplier(SupplierDTO supplierDTO) {
        SupplierEntity supplierEntity = new SupplierEntity(
            supplierDTO.getId(),
            supplierDTO.getCompanyName(),
            supplierDTO.getWebsite(),
            supplierDTO.getLocation(),
            supplierDTO.getNatureOfBusiness(),
            supplierDTO.getManufacturingProcesses()
        );
        SupplierEntity savedEntity = supplierRepository.save(supplierEntity);
        return convertToDTO(savedEntity);
    }

    public List<SupplierDTO> getSuppliers(String location, NatureOfBusiness natureOfBusiness, Set<ManufacturingProcess> manufacturingProcesses, int limit) {
        // Convert Set to List if necessary
        // Set<ManufacturingProcess> processList = manufacturingProcesses.stream()
        //         .collect(Collectors.toList());

        List<SupplierEntity> suppliers = supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcessesIn(
                location,
                natureOfBusiness,
                manufacturingProcesses
        );

        return suppliers.stream()
                .limit(limit)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private SupplierDTO convertToDTO(SupplierEntity entity) {
        return new SupplierDTO(entity.getId(), entity.getCompanyName(), entity.getWebsite(), 
                               entity.getLocation(), entity.getNatureOfBusiness(), 
                               entity.getManufacturingProcesses());
    }
}
