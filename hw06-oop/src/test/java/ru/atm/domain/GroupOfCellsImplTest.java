package ru.atm.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.atm.services.cells.CellForFiveHundredBanknotes;
import ru.atm.services.cells.CellForFiveThousandBanknotes;
import ru.atm.services.cells.CellForOneHundredBanknotes;
import ru.atm.services.cells.CellForOneThousandBanknotes;

@DisplayName("Сервис GroupOfCellsImpl должен ")
class GroupOfCellsImplTest {

    @DisplayName("корректно сложить сумму во всех банковских ячейках")
    @Test
    void getSumInAllCellsTest() {
        var groupOfCells = new GroupOfCellsImpl(
                new CellForFiveThousandBanknotes(5000),
                new CellForOneThousandBanknotes(1000),
                new CellForFiveHundredBanknotes(500),
                new CellForOneHundredBanknotes(100));

        int actual = groupOfCells.getSumInAllCells();
        Assertions.assertEquals(6600000, actual);
    }
}