package dev.dcoder.resourceserver.service;

import dev.dcoder.resourceserver.domain.Account;

public interface AccountService {
    Account getByAccountNumber(String accountNumber);

    Account createAccount(Account account);

}
