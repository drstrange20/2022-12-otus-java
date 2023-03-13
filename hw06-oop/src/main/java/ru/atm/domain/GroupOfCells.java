package ru.atm.domain;

import ru.atm.api.serveces.AtmCells;

import java.util.ArrayList;
import java.util.List;

public class GroupOfCells {
    private final List<AtmCells> cellsList = new ArrayList<>();
    public void addCell(AtmCells atmCell) {
        cellsList.add(atmCell);
    }
    public int getTotalSumInAllCells() {
        return cellsList.stream()
                .mapToInt(AtmCells::getTotalSumInCell)
                .sum();
    }

}
