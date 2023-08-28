package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.medicare.Account;
import com.medicare.Login;
import com.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@RequestBody Account account) {
        String result = accountService.createAccount(account);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/amount")
    public ResponseEntity<Float> getAccountAmount(@RequestParam String email) {
        float amount = accountService.getAccountAmount(email);
        return ResponseEntity.ok(amount);
    }
    
    @PutMapping("/modify")
    public ResponseEntity<Float> modifyAccountAmount(@RequestParam String email, @RequestParam float newAmount) {
        float modifiedAmount = accountService.modifyAccountAmount(email, newAmount);
        return ResponseEntity.ok(modifiedAmount);
    }

    

}

