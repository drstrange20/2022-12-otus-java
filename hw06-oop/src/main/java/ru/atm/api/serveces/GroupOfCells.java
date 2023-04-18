package ru.atm.api.serveces;


import ru.atm.domain.AtmCells;

import java.util.List;

public interface GroupOfCells {
    int getSumInAllCells();
    List<AtmCells> getCellsList();
}
