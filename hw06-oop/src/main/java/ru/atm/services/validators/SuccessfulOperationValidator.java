package ru.atm.services.validators;

import ru.atm.api.serveces.Validator;

public class SuccessfulOperationValidator implements Validator {
    @Override
    public boolean validate(int sum) {
        return sum == 0;
    }
}
