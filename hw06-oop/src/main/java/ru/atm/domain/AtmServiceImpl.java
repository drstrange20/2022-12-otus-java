package ru.atm.domain;


import ru.atm.api.serveces.*;
import ru.atm.services.validators.*;

public class AtmServiceImpl implements WithdrawalService, DepositService {
    private final GroupOfCellsImpl groupOfCells;
    private final DepositBox depositBox;
    private int atmBalance;
    public AtmServiceImpl(GroupOfCellsImpl groupOfCells, DepositBox depositBox) {
        this.groupOfCells = groupOfCells;
        this.depositBox = depositBox;
        atmBalance = groupOfCells.getSumInAllCells();
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void updateAtmBalance() {
        atmBalance = groupOfCells.getSumInAllCells();
    }

    public Wallet withdrawMoney(int sum) {
        int result = sum;

        if (new NotEnoughMoneyValidator().validate(getAtmBalance(), sum)) {
            throw new IllegalArgumentException();
        }

        if (new CorrectSumValidator().validate(sum)) {
            throw new IllegalArgumentException();
        }

        int amountOfBanknotes;
        for (AtmCells cell : groupOfCells.getCellsList()) {
            amountOfBanknotes = sum / cell.getBanknoteValue();
            cell.setAmountOfBanknotes(amountOfBanknotes);

            if (new AmountOfBanknotesValidator().validate(amountOfBanknotes, cell.getAmountOfBanknotesInCell())) {
                amountOfBanknotes = cell.getAmountOfBanknotesInCell();
                groupOfCells.removeCellFromList(cell);
            }

            sum = sum - amountOfBanknotes * cell.getBanknoteValue();

            if (new SuccessfulOperationValidator().validate(sum)) {
                updateAtmBalance();
                return new Wallet(result);
            }

        }
        if (new NotEnoughBanknotesValidator().validate(sum)) {
            throw new IllegalArgumentException();
        }
        updateAtmBalance();
        return new Wallet(result);
    }

    public void depositMoney(int sum, int amountOfBanknotes, Account account) {
        int result = amountOfBanknotes + depositBox.getAmountOfBanknotes();

        if (new FullAtmValidator().validate(result, depositBox.getMaxAmountOfBanknotes())) {
            throw new IllegalArgumentException();
        }

        account.setAccountValue(sum);
        depositBox.setActualAmountOfBanknotes(result);
    }
}