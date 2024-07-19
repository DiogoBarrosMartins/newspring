package com.game.api.login.service;

import com.game.api.login.dto.AccountDTO;
import com.game.api.login.dto.AccountMapper;
import com.game.api.login.entity.Account;
import com.game.api.login.exceptions.EmailAlreadyExistsException;
import com.game.api.login.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

   @Autowired
    private AccountRepository accountRepository;
   @Autowired
    private AccountMapper accountMapper;


    public AccountDTO createAccount(AccountDTO accountDTO) {

            Account account = accountMapper.dtoToEntity(accountDTO);
            if ((accountRepository.findByUsername(account.getUsername()).isPresent())) {
                throw new EmailAlreadyExistsException("Email or username already exists:" + accountDTO.getUsername());
            }
            Account createdAccount = accountRepository.save(account);
            return accountMapper.entityToDto(createdAccount);

    }

    public boolean authenticate(String username, String password) {
        Account a = accountRepository.findByUsername(username).orElseThrow();
        return accountRepository.countByUsernameAndPassword(username, password) > 0;
    }

    @Transactional(readOnly = true)
    public List<Account> getAllPlayers() {
        return accountRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Account> getPlayerById(Long id) {
        return accountRepository.findById(id);
    }



    @Transactional
    public Account updatePlayer(Long id, String firstName, String lastName, String email) {
        Account player = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found"));
        player.setUsername(firstName);
        player.setPassword(lastName);


        return accountRepository.save(player);
    }

    @Transactional
    public void deletePlayer(Long id) {
        accountRepository.deleteById(id);
    }
}
