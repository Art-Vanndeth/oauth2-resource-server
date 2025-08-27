package dev.dcoder.resourceserver.controller;

import dev.dcoder.resourceserver.domain.Account;
import dev.dcoder.resourceserver.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{accountNumber}")
    public Account getByAccountNumber(@PathVariable String accountNumber) {
        return accountService.getByAccountNumber(accountNumber);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_openid')")
    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

}
