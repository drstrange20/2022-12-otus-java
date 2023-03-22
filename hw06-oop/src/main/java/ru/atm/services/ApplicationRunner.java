package ru.atm.services;

import ru.atm.api.serveces.CommandHandler;
import ru.atm.domain.AutomaticTellerMachine;
import service.InputService;

public class ApplicationRunner {
    private final ConsoleOutputService outputService;
    private final InputService inputService;
    private final CommandHandler commandHandler;
    private boolean isRunning = true;

    public boolean getIsRunning() {
        return isRunning;
    }

    public void setRunningToFalse() {
        isRunning = false;
    }

    public ApplicationRunner(ConsoleOutputService outputService,
                             CommandHandler commandHandler,
                             InputService inputService) {
        this.outputService = outputService;
        this.commandHandler = commandHandler;
        this.inputService = inputService;
    }

    public void run(AutomaticTellerMachine atm) {
        while (getIsRunning()) {
            outputService.printChoiceOperationMessage();
            String command = inputService.readString();

            if (commandHandler.handleExitCommand(command)) {
                setRunningToFalse();
                outputService.printGoodByeMessage();
            } else if (commandHandler.handleGiveMoneyCommand(command)) {
                outputService.printMessageAboutCorrectSum();
                int sum = inputService.readInt();
                var wallet = atm.giveMeMoney(sum);
            } else {
                outputService.printPutYourMoneyMessage();
                int sum = inputService.readInt();
                int amountOfBanknotes = inputService.readInt();
                var wallet = atm.takeMyMoney(sum, amountOfBanknotes);
            }
        }
    }
}