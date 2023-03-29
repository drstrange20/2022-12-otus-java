package ru.atm.services.validators;

import ru.atm.api.serveces.Validator;

public class CorrectSumValidator implements Validator {
    @Override
    public boolean validate(int sum) {
        return sum % 100 != 0;
    }

    @Override
    public void errorMessage() {
        outputService.printMessageAboutCorrectSum();
    }
}
