package ru.atm.domain;

import ru.atm.services.DepositBox;
import ru.atm.services.cells.*;

public class AutomaticTellerMachine {
    private final CellForFiveThousandBanknotes cellForFiveThousandBanknotes;
    private final CellForTwoThousandBanknotes cellForTwoThousandBanknotes;
    private final CellForOneThousandBanknotes cellForOneThousandBanknotes;
    private final CellForFiveHundredBanknotes cellForFiveHundredBanknotes;
    private final CellForTwoHundredBanknotes cellForTwoHundredBanknotes;
    private final CellForOneHundredBanknotes cellForOneHundredBanknotes;
    private final CellForFiftyBanknotes cellForFiftyBanknotes;
    private final DepositBox depositBox;

    public AutomaticTellerMachine(CellForFiveThousandBanknotes cellForFiveThousandBanknotes,
                                  CellForTwoThousandBanknotes cellForTwoThousandBanknotes,
                                  CellForOneThousandBanknotes cellForOneThousandBanknotes,
                                  CellForFiveHundredBanknotes cellForFiveHundredBanknotes,
                                  CellForTwoHundredBanknotes cellForTwoHundredBanknotes,
                                  CellForOneHundredBanknotes cellForOneHundredBanknotes,
                                  CellForFiftyBanknotes cellForFiftyBanknotes,
                                  DepositBox depositBox) {
        this.cellForFiveThousandBanknotes = cellForFiveThousandBanknotes;
        this.cellForTwoThousandBanknotes = cellForTwoThousandBanknotes;
        this.cellForOneThousandBanknotes = cellForOneThousandBanknotes;
        this.cellForFiveHundredBanknotes = cellForFiveHundredBanknotes;
        this.cellForTwoHundredBanknotes = cellForTwoHundredBanknotes;
        this.cellForOneHundredBanknotes = cellForOneHundredBanknotes;
        this.cellForFiftyBanknotes = cellForFiftyBanknotes;
        this.depositBox = depositBox;
    }
}
