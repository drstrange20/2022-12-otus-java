package ru.atm.services;

import ru.atm.api.serveces.CommandHandler;

public class CommandHandlerImpl implements CommandHandler {
    private static final String EXIT_COMMAND = "EXIT";
    private static final String GIVE_MONEY_COMMAND = "СНЯТИЕ";
    private static final String TAKE_MONEY_COMMAND = "ВНЕСЕНИЕ";

    @Override
    public boolean handleExitCommand(String command) {
        if (!command.equals(EXIT_COMMAND)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean handleGiveMoneyCommand(String command) {
        if (command.equals(GIVE_MONEY_COMMAND)){
            return true;
        }
        return false;
    }

    @Override
    public boolean handleTakeMoneyCommand(String command) {
        if (command.equals(TAKE_MONEY_COMMAND)){
            return true;
        }
        return false;
    }
}