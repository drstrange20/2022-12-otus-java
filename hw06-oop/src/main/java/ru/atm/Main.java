package ru.atm;


import ru.atm.domain.AutomaticTellerMachine;
import ru.atm.domain.GroupOfCells;
import ru.atm.services.ApplicationRunner;
import ru.atm.domain.DepositBox;
import ru.atm.services.CommandHandlerImpl;
import ru.atm.services.ConsoleInputService;
import ru.atm.services.ConsoleOutputService;
import ru.atm.services.cells.*;

public class Main {
    public static void main(String[] args) {
        var groupOfCells = new GroupOfCells();

        var cellForFiveThousandBanknotes = new CellForFiveThousandBanknotes(5000);
        var cellForOneThousandBanknotes = new CellForOneThousandBanknotes(1000);
        var cellForFiveHundredBanknotes = new CellForFiveHundredBanknotes(500);
        var cellForOneHundredBanknotes = new CellForOneHundredBanknotes(100);

        var depositBox = new DepositBox();

        groupOfCells.addCell(cellForFiveThousandBanknotes);
        groupOfCells.addCell(cellForOneThousandBanknotes);
        groupOfCells.addCell(cellForFiveHundredBanknotes);
        groupOfCells.addCell(cellForOneHundredBanknotes);

        var outputService = new ConsoleOutputService();
        var inputService = new ConsoleInputService();

        var handler = new CommandHandlerImpl();

        var atm = new AutomaticTellerMachine(groupOfCells, depositBox, outputService);

        var appRunner = new ApplicationRunner(outputService, handler, inputService);
        appRunner.run(atm);
    }
}