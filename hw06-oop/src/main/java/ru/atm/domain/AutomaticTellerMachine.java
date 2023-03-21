package ru.atm.domain;


import ru.atm.services.ConsoleOutputService;

public class AutomaticTellerMachine {
    private final GroupOfCells groupOfCells;
    private final DepositBox depositBox;
    private final ConsoleOutputService outputService;
    private int atmBalance;

    public AutomaticTellerMachine(GroupOfCells groupOfCells, DepositBox depositBox, ConsoleOutputService outputService) {
        this.groupOfCells = groupOfCells;
        this.depositBox = depositBox;
        atmBalance = groupOfCells.getTotalSumInAllCells();
        this.outputService = outputService;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance) {
        this.atmBalance = atmBalance;
    }

    public Wallet giveMeMoney(int sum) {
        if (sum % 100 != 0) {
            outputService.printMessageAboutCorrectSum();
            return null;
        }

        if (getAtmBalance() < sum) {
            return null;
        }

        int amountOfBanknotes;
        for (AtmCells cell : groupOfCells.getCellsList()) {
            amountOfBanknotes = sum % cell.getBanknoteValue();
            cell.setAmountOfBanknotes(amountOfBanknotes);
            sum = sum - amountOfBanknotes * cell.getBanknoteValue();
            if (sum == 0) {
                break;
            }
        }
        return new Wallet(sum);
    }

    public Wallet takeMyMoney(int sum, int amountOfBanknotes) {
        if ((amountOfBanknotes + depositBox.getAmountOfBanknotes()) > depositBox.maxAmountOfBanknotes) {

            return null;
        }

        depositBox.setActualAmountOfBanknotes(amountOfBanknotes);
        return new Wallet(sum);
    }
}
