package ru.atm.api.serveces;

public interface CommandHandler {
    boolean handleExitCommand(String command);
    boolean handleGiveMoneyCommand(String command);
    boolean handleTakeMoneyCommand(String command);
}
