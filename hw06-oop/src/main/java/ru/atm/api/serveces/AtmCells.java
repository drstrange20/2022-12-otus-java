package ru.atm.api.serveces;

import java.util.ArrayList;
import java.util.List;

public abstract class AtmCells {
    private final int banknoteValue;
    private int amountOfBanknotesInCell;

    public int getTotalSumInCell() {
        return getAmountOfBanknotesInCell() * getBanknoteValue();
    }

    public int getAmountOfBanknotesInCell() {
        return amountOfBanknotesInCell;
    }

    public void setAmountOfBanknotesInCell(int amountOfBanknotesInCell) {
        this.amountOfBanknotesInCell = amountOfBanknotesInCell;
    }

    public int getBanknoteValue() {
        return banknoteValue;
    }

    protected AtmCells(int banknoteValue) {
        this.banknoteValue = banknoteValue;
        amountOfBanknotesInCell = 1000;
    }
}