package ru.atm.api.serveces;

import ru.atm.services.ConsoleOutputService;

public interface Validator {
    ConsoleOutputService outputService = new ConsoleOutputService();

    default boolean validate(int sum) {
        return true;
    }

    default boolean validate(int sum1, int sum2) {
        return true;
    }

    default void errorMessage() {

    }
}
