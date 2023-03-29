package ru.atm.domain;

import ru.atm.api.serveces.GroupOfCells;

import java.util.ArrayList;
import java.util.List;

public class GroupOfCellsImpl implements GroupOfCells {
    private final List<AtmCells> cellsList;

    public GroupOfCellsImpl() {
        cellsList = new ArrayList<>();
    }

    @Override
    public void addCell(AtmCells atmCell) {
        cellsList.add(atmCell);
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

}