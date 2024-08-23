package com.anoop.rest_service.dto;

import com.anoop.rest_service.enums.ManufacturingProcess;
import com.anoop.rest_service.enums.NatureOfBusiness;

import java.util.Set;

public class SupplierDTO {

    private Long Id;
    private String companyName;
    private String website;
    private String location;
    private NatureOfBusiness natureOfBusiness;
    private Set<ManufacturingProcess> manufacturingProcesses;

    // Constructors

    public SupplierDTO() {
        // Default constructor
    }

    public SupplierDTO(Long Id, String companyName, String website, String location, 
                       NatureOfBusiness natureOfBusiness, Set<ManufacturingProcess> manufacturingProcesses) {
        this.Id = Id;
        this.companyName = companyName;
        this.website = website;
        this.location = location;
        this.natureOfBusiness = natureOfBusiness;
        this.manufacturingProcesses = manufacturingProcesses;
    }

    // Getters and Setters

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public NatureOfBusiness getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(NatureOfBusiness natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public Set<ManufacturingProcess> getManufacturingProcesses() {
        return manufacturingProcesses;
    }

    public void setManufacturingProcesses(Set<ManufacturingProcess> manufacturingProcesses) {
        this.manufacturingProcesses = manufacturingProcesses;
    }
}
