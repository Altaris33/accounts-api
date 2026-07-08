package com.captain.accounts_api.mapper;

import com.captain.accounts_api.dto.AccountDto;
import com.captain.accounts_api.entity.Account;

public class AccountMapper {

    public static AccountDto toAccountDto(Account account) {
        AccountDto dto = new AccountDto();
        dto.setAccountNumber(account.getAccountNumber());
        dto.setAccountType(account.getAccountType());
        dto.setBranchAddress(account.getBranchAddress());
        return dto;
    }

    public static Account toAccount(AccountDto dto) {
        Account account = new Account();
        account.setAccountNumber(dto.getAccountNumber());
        account.setAccountType(dto.getAccountType());
        account.setBranchAddress(dto.getBranchAddress());
        return account;
    }
}
