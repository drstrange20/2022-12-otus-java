package ru.atm.domain;

public class Wallet {
    private int walletBalance;

    public Wallet(int walletBalance) {
        this.walletBalance = walletBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wallet wallet = (Wallet) o;

        return walletBalance == wallet.walletBalance;
    }

    @Override
    public int hashCode() {
        return walletBalance;
    }
}