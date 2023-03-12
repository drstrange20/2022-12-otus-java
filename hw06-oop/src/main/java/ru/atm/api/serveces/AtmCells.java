package ru.atm.api.serveces;

public abstract class AtmCells {
    private int banknotesValue;
    private final int maxAmountOfBanknotesInCell = 2500;
    private int actualAmountOfBanknotes;
    private int totalSumInCell;

    public int getTotalSumInCell() {
        return actualAmountOfBanknotes * banknotesValue;
    }

    public int getActualAmountOfBanknotes() {
        return actualAmountOfBanknotes;
    }

    public void setActualAmountOfBanknotes(int actualAmountOfBanknotes) {
        this.actualAmountOfBanknotes = actualAmountOfBanknotes;
    }
}
