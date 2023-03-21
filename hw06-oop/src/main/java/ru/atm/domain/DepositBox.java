package ru.atm.domain;


public class DepositBox {
    int maxAmountOfBanknotes = 2500;

    private int actualAmountOfBanknotes = 0;

    public int getAmountOfBanknotes() {
        return actualAmountOfBanknotes;
    }

    public void setActualAmountOfBanknotes(int actualAmountOfBanknotes) {
        this.actualAmountOfBanknotes = getAmountOfBanknotes() + actualAmountOfBanknotes;
    }
}
