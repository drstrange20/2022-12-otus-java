package ru.atm.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Сервис CommandHandlerImpl должен ")
class CommandHandlerImplTest {

    @DisplayName("вернуть true, если команда = ВЫХОД")
    @Test
    void handleExitCommandTest1() {
        boolean actual = new CommandHandlerImpl().handleExitCommand("ВЫХОД");
        Assertions.assertTrue(actual);
    }

    @DisplayName("вернуть false, если команда != ВЫХОД")
    @Test
    void handleExitCommandTest2() {
        boolean actual = new CommandHandlerImpl().handleExitCommand("СНЯТИЕ");
        Assertions.assertFalse(actual);
    }

    @DisplayName("вернуть true, если команда = СНЯТИЕ")
    @Test
    void handleWithdrawCommandTest1() {
        boolean actual = new CommandHandlerImpl().handleWithdrawMoneyCommand("СНЯТИЕ");
        Assertions.assertTrue(actual);
    }

    @DisplayName("вернуть false, если команда != СНЯТИЕ")
    @Test
    void handleWithdrawCommandTest2() {
        boolean actual = new CommandHandlerImpl().handleWithdrawMoneyCommand("ВЫХОД");
        Assertions.assertFalse(actual);
    }
}