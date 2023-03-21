package ru.atm.services;

import service.OutputService;

public class ConsoleOutputService implements OutputService {
    public void printMessageAboutCorrectSum() {
        outputMessage("Введите сумму кратную 100 рублям");
    }

    public void printAtmIsFullMessage() {
        outputMessage("Банкомат переполнен");
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
}