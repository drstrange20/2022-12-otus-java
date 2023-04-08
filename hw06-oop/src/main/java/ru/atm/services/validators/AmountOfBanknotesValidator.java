package ru.atm.services.validators;

import ru.atm.api.serveces.Validator;

public class AmountOfBanknotesValidator implements Validator {
    @Override
    public boolean validate(int amountOfBanknotes, int amountOfBanknotesInCell) {
        return amountOfBanknotes > amountOfBanknotesInCell;
    }
}
