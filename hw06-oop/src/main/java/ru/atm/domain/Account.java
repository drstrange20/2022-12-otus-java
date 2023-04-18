package ru.atm.domain;

public class Account {
    private int accountValue;

    public Account(int accountValue) {
        this.accountValue = accountValue;
    }

    public int getAccountValue() {
        return accountValue;
    }

    public void setAccountValue(int amountOfBanknotes) {
        accountValue = getAccountValue() + amountOfBanknotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return accountValue == account.accountValue;
    }

    @Override
    public int hashCode() {
        return accountValue;
    }
}
