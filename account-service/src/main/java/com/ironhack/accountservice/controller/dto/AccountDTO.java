package com.ironhack.accountservice.controller.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AccountDTO {

    private Long id;

    @NotNull
    private String industry;

    @Min(value = 1, message = "Employee Count Must 1 Or More")
    private int employeeCount;
    @NotNull
    private String city;
    @NotNull
    private String country;


    public AccountDTO(Long id, String industry, int employeeCount, String city, String country) {
        this.id = id;
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
