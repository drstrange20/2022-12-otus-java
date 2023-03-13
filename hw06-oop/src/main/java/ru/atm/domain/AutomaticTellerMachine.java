package ru.atm.domain;


public class AutomaticTellerMachine {
    private final GroupOfCells groupOfCells;
    private int atmBalance;

    public AutomaticTellerMachine(GroupOfCells groupOfCells) {
        this.groupOfCells = groupOfCells;
        atmBalance = groupOfCells.getTotalSumInAllCells();
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance) {
        this.atmBalance = atmBalance;
    }
}
