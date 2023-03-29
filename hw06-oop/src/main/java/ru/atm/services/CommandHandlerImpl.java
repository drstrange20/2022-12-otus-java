package ru.atm.services;

import ru.atm.api.serveces.CommandHandler;

public class CommandHandlerImpl implements CommandHandler {
    private static final String EXIT_COMMAND = "ВЫХОД";
    private static final String GIVE_MONEY_COMMAND = "СНЯТИЕ";

    @Override
    public boolean handleExitCommand(String command) {
        return command.equals(EXIT_COMMAND);
    }

    @Override
    public boolean handleWithdrawMoneyCommand(String command) {
        return command.equals(GIVE_MONEY_COMMAND);
    }
}