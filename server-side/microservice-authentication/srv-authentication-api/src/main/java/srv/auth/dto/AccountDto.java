/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import srv.auth.model.Account;

/**
 * AccountDto.
 *
 * @author waldemar
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDto {

    private Long id;
    private String login;

    public Account toAccount() {
        Account account = new Account();

        account.setId(id);
        account.setLogin(login);

        return account;
    }

    public static AccountDto fromAccount(Account account) {

        AccountDto accountDto = new AccountDto();

        accountDto.setId(account.getId());
        accountDto.setLogin(account.getLogin());

        return accountDto;
    }
}