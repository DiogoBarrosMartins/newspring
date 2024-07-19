package com.game.api.login.controller;

import com.game.api.login.dto.AccountDTO;
import com.game.api.login.entity.Account;
import com.game.api.login.entity.LoginRequest;
import com.game.api.login.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO) {
        AccountDTO createdAccount = accountService.createAccount(accountDTO);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody LoginRequest loginRequest) {
        boolean isAuthenticated = accountService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        System.out.println(isAuthenticated + "isAuth");
        if (isAuthenticated) {
            return ResponseEntity.ok("Authenticated successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid username or password");
        }
    }



    @GetMapping
    public List<Account> getPlayers() {
        return accountService.getAllPlayers();
    }




    @GetMapping("/{id}")
    public Optional<Account> getPlayer(@PathVariable Long id) {
        return accountService.getPlayerById(id);
    }



    @PatchMapping("/{id}")
    public Account updatePlayer(@PathVariable Long id, @RequestBody String firstName, @RequestParam String lastName, @RequestParam String email) {
        return accountService.updatePlayer(id, firstName, lastName, email);
    }

    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable Long id) {
        try {
            accountService.deletePlayer(id);
            return "Deleted";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
