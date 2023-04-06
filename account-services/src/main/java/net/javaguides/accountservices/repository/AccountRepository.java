package net.javaguides.accountservices.repository;

import net.javaguides.accountservices.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, String> {
}
