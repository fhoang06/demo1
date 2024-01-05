package com.example.demo.controller;

import com.example.demo.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ScheduledTask {
    @Autowired
    private BankAccountService bankAccountService;

    @Scheduled(cron = "*/10 * * * * * ")
    public void automaticTransfer() {
        try {
            bankAccountService.transferMoney(1L,2L,new BigDecimal("100"));
            System.out.println("Automatic transfer completed successfully.");
        } catch (Exception e)
        {
            System.out.println("Error during automatic transfer: " + e.getMessage());
        }
    }
}
