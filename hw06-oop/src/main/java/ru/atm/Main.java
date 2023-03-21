package ru.atm;

/*
Если в банкомате кассеты исчерпываются неравномерно, банкомат выдаёт клиенту информацию
о том, что снять наличные можно на сумму, кратную определённому числу.

Принцип действия банкомата следующий. После введения карты банкомат запрашивает ПИН-код (секретный код),
далее пользователь осуществляет запрос на проведение определенной операции. Запрошенная операция,
ПИН-код, содержимое карты (магнитная полоса и др.) шифруются и направляются в систему банка, который
обслуживает данное устройство (этот банк называется банк-эквайер). Далее запрос поступает в платежную
систему, которая, в свою очередь, маршрутизирует запрос в банк, который выпустил карту.
После рассмотрения запроса ответ поступает в банкомат. Весь этот длинный путь запроса фиксируется
в банкомате, чтобы в случае возникновения спорных ситуаций можно было провести расследование.

Применить на практике принципы SOLID.
Написать эмулятор АТМ (банкомата).
Объект класса АТМ должен уметь:
принимать банкноты разных номиналов (на каждый номинал должна быть своя ячейка)
выдавать запрошенную сумму минимальным количеством банкнот или ошибку, если сумму нельзя выдать.
Это задание не на алгоритмы, а на проектирование.
Поэтому оптимизировать выдачу не надо.
В этом задании больше думайте об архитектуре приложения.
Не отвлекайтесь на создание таких объектов как: пользователь, авторизация, клавиатура,
дисплей, UI (консольный, Web, Swing), валюта, счет, карта, т.д.
Все это не только не нужно, но и вредно!*/


import ru.atm.domain.AutomaticTellerMachine;
import ru.atm.domain.GroupOfCells;
import ru.atm.services.ApplicationRunner;
import ru.atm.domain.DepositBox;
import ru.atm.services.CommandHandlerImpl;
import ru.atm.services.ConsoleInputService;
import ru.atm.services.ConsoleOutputService;
import ru.atm.services.cells.*;
import service.InputService;

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