package ru.atm.api.serveces;

public abstract class AtmCells {
    protected int actualAmountOfBanknotes;
    private int getTotalSumInCell(int banknoteValue) {
        return actualAmountOfBanknotes * banknoteValue;
    }

    public int getActualAmountOfBanknotes() {
        return actualAmountOfBanknotes;
    }

    public void setActualAmountOfBanknotes(int actualAmountOfBanknotes) {
        this.actualAmountOfBanknotes = actualAmountOfBanknotes;
    }

    public AtmCells() {
        actualAmountOfBanknotes = 2500;
    }
}
