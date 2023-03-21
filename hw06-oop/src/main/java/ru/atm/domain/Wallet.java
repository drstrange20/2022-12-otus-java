package ru.atm.domain;

public class Wallet {
    private int walletBalance;

    public Wallet(int walletBalance) {
        this.walletBalance = walletBalance;
    }

    public int getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(int walletBalance) {
        this.walletBalance = walletBalance;
    }
}