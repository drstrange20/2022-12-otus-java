package ru.atm.api.serveces;

public interface CommandHandler {
    boolean handleExitCommand(String command);
    boolean handleWithdrawMoneyCommand(String command);
}
