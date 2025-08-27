package dev.dcoder.resourceserver.repository;

import dev.dcoder.resourceserver.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findByAccountNumber(String accountNumber);
    Boolean existsByAccountNumber(String accountNumber);
}
