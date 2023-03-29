package ru.atm.api.serveces;

import ru.atm.domain.Wallet;

@FunctionalInterface
public interface WithdrawalService {
    Wallet withdrawMoney(int sum);
}
