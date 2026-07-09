package com.captain.accounts_api.dto;

public class CustomerDto {

    private String name;
    private String email;
    private String mobileNumber;
    private AccountDto accountDto;


    public CustomerDto() {
    }

    public CustomerDto(String name, String email, String mobileNumber, AccountDto accountDto) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.accountDto = accountDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public AccountDto getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(AccountDto accountDto) {
        this.accountDto = accountDto;
    }
}
