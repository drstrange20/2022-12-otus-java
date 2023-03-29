package ru.atm.services;

import ru.atm.api.serveces.CommandHandler;
import ru.atm.domain.AtmServiceImpl;
import service.InputService;

public class ApplicationRunner {
    private final ConsoleOutputService outputService;
    private final InputService inputService;
    private final CommandHandler commandHandler;
    private boolean isRunning = true;

    public boolean getIsRunning() {
        return isRunning;
    }

    public void setVariableToFalse() {
        isRunning = false;
    }

    public ApplicationRunner(ConsoleOutputService outputService,
                             CommandHandler commandHandler,
                             InputService inputService) {
        this.outputService = outputService;
        this.commandHandler = commandHandler;
        this.inputService = inputService;
    }

    public void run(AtmServiceImpl atm) {
        while (getIsRunning()) {
            outputService.printChoiceOperationMessage();
            String command = inputService.readString();

            try {
                if (commandHandler.handleExitCommand(command)) {
                    setVariableToFalse();
                    outputService.printGoodByeMessage();
                } else if (commandHandler.handleWithdrawMoneyCommand(command)) {
                    outputService.printMessageAboutCorrectSum();
                    int sum = inputService.readInt();
                    var wallet = atm.withdrawMoney(sum);
                } else {
                    outputService.printPutYourMoneyMessage();
                    int sum = inputService.readInt();
                    int amountOfBanknotes = inputService.readInt();
                    var wallet = atm.depositMoney(sum, amountOfBanknotes);
                }
            } catch (IllegalArgumentException e) {
                outputService.outputException(e.getMessage());
            }
        }
    }
}