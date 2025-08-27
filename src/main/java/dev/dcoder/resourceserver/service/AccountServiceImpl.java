package dev.dcoder.resourceserver.service;

import dev.dcoder.resourceserver.domain.Account;
import dev.dcoder.resourceserver.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Account getByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Override
    public Account createAccount(Account account) {
        if (accountRepository.existsByAccountNumber(account.getAccountNumber())) {
            throw new RuntimeException("Account already exists");
        }
        return accountRepository.save(account);
    }
}
