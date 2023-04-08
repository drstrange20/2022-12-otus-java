package ru.atm.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.atm.services.cells.CellForFiveHundredBanknotes;
import ru.atm.services.cells.CellForFiveThousandBanknotes;
import ru.atm.services.cells.CellForOneHundredBanknotes;
import ru.atm.services.cells.CellForOneThousandBanknotes;

@DisplayName("Сервис AtmServiceImpl должен, ")
class AtmServiceImplTest {

    @DisplayName("выдавать сумму наличными, используя наименьшее количество банкнот")
    @Test
    void withdrawMoney() {
        var groupOfCells = new GroupOfCellsImpl(
                new CellForFiveThousandBanknotes(5000),
                new CellForOneThousandBanknotes(1000),
                new CellForFiveHundredBanknotes(500),
                new CellForOneHundredBanknotes(100));
        var depositBox = new DepositBox();

        var atmService = new AtmServiceImpl(groupOfCells, depositBox);
        var wallet = atmService.withdrawMoney(200000);

        Assertions.assertEquals(960, groupOfCells.getCellsList().get(0).getAmountOfBanknotesInCell());
        Assertions.assertEquals(new Wallet(200000), wallet);
        Assertions.assertEquals(6400000, groupOfCells.getSumInAllCells());
    }

    @DisplayName("принимать наличные и зачислять средства на счет")
    @Test
    void depositMoney() {
        var groupOfCells = new GroupOfCellsImpl(
                new CellForFiveThousandBanknotes(5000),
                new CellForOneThousandBanknotes(1000),
                new CellForFiveHundredBanknotes(500),
                new CellForOneHundredBanknotes(100));

        var depositBox = new DepositBox();
        var account = new Account(10000);
        var atmService = new AtmServiceImpl(groupOfCells, depositBox);

        int amountOfBanknotes = 23;
        var expectedDepositBox = new DepositBox();
        expectedDepositBox.setActualAmountOfBanknotes(amountOfBanknotes);

        atmService.depositMoney(23000, amountOfBanknotes, account);

        Assertions.assertEquals(new Account(33000), account);
        Assertions.assertEquals(expectedDepositBox.getAmountOfBanknotes(), depositBox.getAmountOfBanknotes());
    }
}