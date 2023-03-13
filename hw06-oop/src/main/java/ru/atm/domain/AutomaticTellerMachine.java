package ru.atm.domain;


import ru.atm.api.serveces.AtmCells;

public class AutomaticTellerMachine {
    private final AtmCells atmCells;
    private int atmBalance;

    public AutomaticTellerMachine(AtmCells atmCells) {
        this.atmCells = atmCells;
        atmBalance = atmCells.getTotalSumInAllCells();
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance) {
        this.atmBalance = atmBalance;
    }
}
