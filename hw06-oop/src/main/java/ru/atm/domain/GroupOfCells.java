package ru.atm.domain;

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

    public List<AtmCells> getCellsList() {
        return cellsList;
    }

}