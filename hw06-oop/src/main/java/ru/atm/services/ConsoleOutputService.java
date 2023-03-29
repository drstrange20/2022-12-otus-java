package ru.atm.services;

import service.OutputService;

import static java.lang.System.*;

public class ConsoleOutputService implements OutputService {
    public void printMessageAboutCorrectSum() {
        outputMessage("Введите сумму кратную 100 рублям");
    }

    public void printAtmIsFullMessage() {
        outputException("Банкомат переполнен");
    }

    public void printChoiceOperationMessage() {
        outputMessage("Выберите операцию: снятие / внесение или выход");
    }

    public void printPutYourMoneyMessage() {
        outputMessage("Внесите деньги в купюроприемник");
    }

    public void printGoodByeMessage() {
        outputMessage("До свидания, не забудьте Вашу карту");
    }

    public void printThereIsNotEnoughMoneyMessage() {
        outputException("В банкомате недостаточно средств, введите другую сумму");
    }

    public void printThereIsNotEnoughBanknotesForThisSumMessage() {
        outputException("Недостаточно банкнот для выдачи данной суммы, введите другую");
    }

    public void outputException(String prompt) {
        err.println(prompt);
    }
}