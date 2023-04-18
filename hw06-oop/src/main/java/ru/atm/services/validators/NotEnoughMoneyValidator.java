package ru.atm.services.validators;

import ru.atm.api.serveces.Validator;

public class NotEnoughMoneyValidator implements Validator {
    @Override
    public boolean validate(int atmBalance, int sum) {
        return atmBalance < sum;
    }

    @Override
    public void errorMessage() {
        outputService.printThereIsNotEnoughMoneyMessage();
    }
}
