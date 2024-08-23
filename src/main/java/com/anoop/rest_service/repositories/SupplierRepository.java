package com.anoop.rest_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.anoop.rest_service.entities.SupplierEntity;
import com.anoop.rest_service.enums.ManufacturingProcess;
import com.anoop.rest_service.enums.NatureOfBusiness;

import java.util.List;
import java.util.Set;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {

    @Query("SELECT s FROM SupplierEntity s WHERE s.location = :location AND s.natureOfBusiness = :natureOfBusiness AND s.manufacturingProcesses = :manufacturingProcesses")
        List<SupplierEntity> findByLocationAndNatureOfBusinessAndManufacturingProcessesIn(
            @Param("location") String location,
            @Param("natureOfBusiness") NatureOfBusiness natureOfBusiness,
            @Param("manufacturingProcesses") Set<ManufacturingProcess> manufacturingProcesses);
}
