package net.javaguides.accountservice.repository;

import net.javaguides.accountservice.entity.AccountEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<AccountEntity, Integer> {
}
