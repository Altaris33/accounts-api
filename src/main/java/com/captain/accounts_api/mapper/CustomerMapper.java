package com.captain.accounts_api.mapper;

import com.captain.accounts_api.dto.CustomerDto;
import com.captain.accounts_api.entity.Customer;

public class CustomerMapper {

    public static CustomerDto toCustomerDto(Customer customer) {
        CustomerDto dto = new CustomerDto();
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setMobileNumber(customer.getMobileNumber());
        return dto;
    }

    public static Customer toCustomer(CustomerDto dto, Customer customer) {
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setMobileNumber(dto.getMobileNumber());
        return customer;
    }
}
