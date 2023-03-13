package ru.atm.api.serveces;

import java.util.ArrayList;
import java.util.List;

public class AtmCells {
    private final List<AtmCells> cellsList = new ArrayList<>();
    private final int banknoteValue;
    private int amountOfBanknotesInCell;
    public void addCell(AtmCells atmCell) {
        cellsList.add(atmCell);
    }

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
    public int getTotalSumInAllCells() {
        return cellsList.stream()
                .mapToInt(AtmCells::getTotalSumInCell)
                .sum();
    }
}