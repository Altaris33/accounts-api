package com.captain.accounts_api.service.impl;

import com.captain.accounts_api.constants.AccountConstants;
import com.captain.accounts_api.dto.AccountDto;
import com.captain.accounts_api.dto.CustomerDto;
import com.captain.accounts_api.entity.Account;
import com.captain.accounts_api.entity.Customer;
import com.captain.accounts_api.exception.CustomerAlreadyExistsException;
import com.captain.accounts_api.exception.ResourceNotFoundException;
import com.captain.accounts_api.mapper.AccountMapper;
import com.captain.accounts_api.mapper.CustomerMapper;
import com.captain.accounts_api.repository.AccountRepository;
import com.captain.accounts_api.repository.CustomerRepository;
import com.captain.accounts_api.service.AccountService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    public AccountServiceImpl(AccountRepository accountRepository,
                              CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer
                = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already exists with this " +
                    "mobileNumber: " + customerDto.getMobileNumber());
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        customer.setUpdatedAt(LocalDateTime.now());
        customer.setUpdatedBy("Anonymous");
        Customer saved = customerRepository.save(customer);
        accountRepository.save(createNewAccount(saved));
    }

    private Account createNewAccount(Customer customer) {
        Account account = new Account();
        account.setCustomerId(customer.getCustomerId());

        long accountNumber = 10000L + new Random().nextInt(900000);
        account.setAccountNumber(accountNumber);

        account.setAccountType(AccountConstants.SAVINGS);
        account.setBranchAddress(AccountConstants.ADDRESS);

        account.setCreatedAt(LocalDateTime.now());
        account.setCreatedBy("Anonymous");
        account.setUpdatedAt(LocalDateTime.now());
        account.setUpdatedBy("Anonymous");

        return account;
    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException(
                        "Account", "customerId", customer.getCustomerId().toString()
                )
        );
        CustomerDto dto = CustomerMapper.toCustomerDto(customer);
        dto.setAccountDto(AccountMapper.toAccountDto(account));
        return dto;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        AccountDto accountDto = customerDto.getAccountDto();
        if (accountDto != null) {
            Account account = accountRepository.findById(accountDto.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Account",
                            "AccountNumber",
                            accountDto.getAccountNumber().toString())
            );
            AccountMapper.toAccount(accountDto, account);
            account = accountRepository.save(account);

            Long customerId = account.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer",
                            "customerID",
                            customerId.toString())
            );
            CustomerMapper.toCustomer(customerDto, customer);
            customerRepository.save(customer);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        accountRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }
}
