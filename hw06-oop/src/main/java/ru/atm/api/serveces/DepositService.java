package ru.atm.api.serveces;

import ru.atm.domain.Wallet;

@FunctionalInterface
public interface DepositService {
    Wallet depositMoney(int sum, int amountOfBanknotes);
}
