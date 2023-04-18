package ru.atm.services.validators;

import ru.atm.api.serveces.Validator;

public class NotEnoughBanknotesValidator implements Validator {
    @Override
    public boolean validate(int sum) {
        return sum > 0;
    }

    @Override
    public void errorMessage() {
        outputService.printThereIsNotEnoughBanknotesForThisSumMessage();
    }
}
