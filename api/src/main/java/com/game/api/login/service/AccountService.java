package com.game.api.login.service;

import com.game.api.login.dto.AccountDTO;
import com.game.api.login.dto.AccountMapper;
import com.game.api.login.entity.Account;
import com.game.api.login.exceptions.EmailAlreadyExistsException;
import com.game.api.login.repository.AccountRepository;
import com.game.api.village.dto.VillageDTO;
import com.game.api.village.entity.Village;
import com.game.api.village.service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private VillageService villageService;

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public AccountDTO createAccount(AccountDTO accountDTO) throws Exception {
        Account account = accountMapper.dtoToEntity(accountDTO);
        if (accountRepository.findByUsername(account.getUsername()).isPresent()) {
            throw new EmailAlreadyExistsException("Email or username already exists: " + accountDTO.getUsername());
        }

        // Save the account first to get the ID
        Account createdAccount = accountRepository.save(account);

        // Create the initial village for the new account
        Village village = villageService.createVillage("New village", createdAccount);

        // Add the village ID to the account's villageIds list
        if (createdAccount.getVillageIds() == null) {
            createdAccount.setVillageIds(new ArrayList<>());
        }
        createdAccount.getVillageIds().add(village.getId());
        accountRepository.save(createdAccount);

        // Return the DTO of the created account
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
    public Account updatePlayer(Long id, String username, String password) {
        Account player = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found"));
        player.setUsername(username);
        player.setPassword(password);

        return accountRepository.save(player);
    }

    @Transactional
    public void deletePlayer(Long id) {
        accountRepository.deleteById(id);
    }



    @Transactional
    public AccountDTO addVillageToAccount(Long accountId, String villageName) {
        Account account = accountRepository.findById(accountId).orElse(null);
        if (account != null) {
            Village village = new Village();
            village.setName(villageName);
            village.setAccount(account);
            Village savedVillageDTO = villageService.createVillage(villageName, account);

            if (account.getVillageIds() == null) {
                account.setVillageIds(new ArrayList<>());
            }
            account.getVillageIds().add(savedVillageDTO.getId());
             accountRepository.save(account);
        }
        return accountMapper.entityToDto(account);
    }

}
