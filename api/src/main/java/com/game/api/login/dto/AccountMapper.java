package com.game.api.login.dto;

import com.game.api.login.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account dtoToEntity(AccountDTO dto) {
        if (dto == null) {
            return null;
        }

        Account entity = new Account();
        entity.setPassword(dto.getPassword());
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setTribe(dto.getTribe());

        return entity;
    }

    public AccountDTO entityToDto(Account entity) {
        if (entity == null) {
            return null;
        }

        AccountDTO dto = new AccountDTO();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setTribe(entity.getTribe());
        dto.setPassword("**hidden**");
        return dto;
    }
}