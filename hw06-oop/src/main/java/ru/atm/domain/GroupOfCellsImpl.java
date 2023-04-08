package ru.atm.domain;

import ru.atm.api.serveces.GroupOfCells;

import java.util.List;

public class GroupOfCellsImpl implements GroupOfCells {
    private final List<AtmCells> cellsList;

    public GroupOfCellsImpl(AtmCells cellForFiveThousandBanknotes,
                            AtmCells cellForOneThousandBanknotes,
                            AtmCells cellForFiveHundredBanknotes,
                            AtmCells cellForOneHundredBanknotes) {

        cellsList = List.of(cellForFiveThousandBanknotes,
                cellForOneThousandBanknotes,
                cellForFiveHundredBanknotes,
                cellForOneHundredBanknotes);
    }

    @Override
    public int getSumInAllCells() {
        return cellsList.stream()
                .mapToInt(AtmCells::getTotalSumInCell)
                .sum();
    }

    @Override
    public List<AtmCells> getCellsList() {
        return cellsList;
    }

    public void removeCellFromList(AtmCells cell) {
        cellsList.remove(cell);
    }
}