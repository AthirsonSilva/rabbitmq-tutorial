package net.javaguides.accountservices.controller;

import java.util.UUID;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import net.javaguides.accountservices.entity.AccountEntity;
import net.javaguides.accountservices.repository.AccountRepository;

@Controller
@RequiredArgsConstructor
public class AccountController {
	private final AccountRepository accountRepository;

	@MutationMapping
	AccountEntity create(@Argument AccountInput account) {
		AccountEntity accountEntity = new AccountEntity();

		accountEntity.setUsername(account.username());
		accountEntity.setUserId(account.userId());
		accountEntity.setRoleId(account.roleId());

		return accountRepository.save(accountEntity);
	}

	@QueryMapping
	Iterable<AccountEntity> findAll() {
		return accountRepository.findAll();
	}

	@QueryMapping
	AccountEntity findById(@Argument String id) {
		return accountRepository.findById(id).orElseThrow();
	}

	record AccountInput(
			String username,
			String userId,
			String roleId
	) {
	}
}
