package ru.atm.services.validators;

import ru.atm.api.serveces.Validator;

public class FullAtmValidator implements Validator {
    @Override
    public boolean validate(int sum1, int sum2) {
        return sum1 > sum2;
    }

    @Override
    public void errorMessage() {
        outputService.printAtmIsFullMessage();
    }
}
