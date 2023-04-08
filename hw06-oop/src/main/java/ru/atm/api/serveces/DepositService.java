package ru.atm.api.serveces;

import ru.atm.domain.Account;

@FunctionalInterface
public interface DepositService {
    void depositMoney(int sum, int amountOfBanknotes, Account account);
}
