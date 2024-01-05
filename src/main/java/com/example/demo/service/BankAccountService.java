package com.example.demo.service;

import com.example.demo.model.BankAccount;
import com.example.demo.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Transactional(rollbackFor = {Exception.class} )
    public void transferMoney(Long fromAccountId, Long toAccountId, BigDecimal amount) {
        try{
            BankAccount fromAccount = bankAccountRepository.findById(fromAccountId)
                    .orElseThrow(() -> new RuntimeException("From account not found"));

            BankAccount toAccount = bankAccountRepository.findById(toAccountId)
                    .orElseThrow(() -> new RuntimeException("To account not found"));

            if (fromAccount.getBalance().compareTo(amount) < 0) {
                throw new RuntimeException("Not enough balance in the source account");
            }
            fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
            toAccount.setBalance(toAccount.getBalance().add(amount));

            bankAccountRepository.save(fromAccount);
            bankAccountRepository.save(toAccount);
        }catch (Exception e)
        {
            throw new RuntimeException("Transaction failed");
        }
    }
}
