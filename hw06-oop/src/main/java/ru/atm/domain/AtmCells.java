package ru.atm.domain;


public class AtmCells {
    private final int banknoteValue;
    private int amountOfBanknotesInCell = 1000;

    protected AtmCells(int banknoteValue) {
        this.banknoteValue = banknoteValue;
    }

    public int getTotalSumInCell() {
        return amountOfBanknotesInCell * banknoteValue;
    }

    public int getAmountOfBanknotesInCell() {
        return amountOfBanknotesInCell;
    }

    public void setAmountOfBanknotes(int amountOfBanknotes) {
        amountOfBanknotesInCell = getAmountOfBanknotesInCell() - amountOfBanknotes;
    }

    public int getBanknoteValue() {
        return banknoteValue;
    }
}