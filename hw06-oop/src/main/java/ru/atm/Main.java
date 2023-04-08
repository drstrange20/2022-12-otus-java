package ru.atm;


import ru.atm.domain.AtmServiceImpl;
import ru.atm.domain.GroupOfCellsImpl;
import ru.atm.services.ApplicationRunner;
import ru.atm.domain.DepositBox;
import ru.atm.services.CommandHandlerImpl;
import ru.atm.services.ConsoleInputService;
import ru.atm.services.ConsoleOutputService;
import ru.atm.services.cells.*;

public class Main {
    public static void main(String[] args) {
        var groupOfCells = new GroupOfCellsImpl(
                new CellForFiveThousandBanknotes(5000),
                new CellForOneThousandBanknotes(1000),
                new CellForFiveHundredBanknotes(500),
                new CellForOneHundredBanknotes(100));

        var depositBox = new DepositBox();

        var outputService = new ConsoleOutputService();
        var inputService = new ConsoleInputService();

        var handler = new CommandHandlerImpl();

        var atm = new AtmServiceImpl(groupOfCells, depositBox);

        var appRunner = new ApplicationRunner(outputService, handler, inputService);
        appRunner.run(atm);
    }
}