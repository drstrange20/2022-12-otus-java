package ru.otus;

import ru.otus.handler.ComplexProcessor;
import ru.otus.listener.ListenerPrinterConsole;
import ru.otus.listener.homework.HistoryListener;
import ru.otus.model.Message;
import ru.otus.model.ObjectForMessage;
import ru.otus.processor.homework.ChangingFieldsProcessor;
import ru.otus.processor.homework.DateTimeProvider;
import ru.otus.processor.homework.DateTimeProviderImpl;
import ru.otus.processor.homework.ExceptionProcessor;

import java.util.ArrayList;
import java.util.List;

public class HomeWork {
    public static void main(String[] args) {
        DateTimeProvider dateTimeProvider = new DateTimeProviderImpl();
        var objectForMessage = new ObjectForMessage();
        var listenerPrinter = new ListenerPrinterConsole();
        var historyListener = new HistoryListener();
        List<String> dataList = new ArrayList<>();
        dataList.add("Some data");
        objectForMessage.setData(dataList);

        var processors = List.of(new ChangingFieldsProcessor(), new ExceptionProcessor(dateTimeProvider));

        var complexProcessor = new ComplexProcessor(processors, ex -> {});
        complexProcessor.addListener(listenerPrinter);
        complexProcessor.addListener(historyListener);

        var message = new Message.Builder(1L)
                .field1("field1")
                .field2("field2")
                .field3("field3")
                .field4("field4")
                .field5("field5")
                .field6("field6")
                .field7("field7")
                .field8("field8")
                .field9("field9")
                .field10("field10")
                .field11("field11")
                .field12("field12")
                .field13(objectForMessage)
                .build();

        var result = complexProcessor.handle(message);
        dataList.clear();
        System.out.println("result:                    " + result); //Для того чтобы в консоли было нагляднее
        var msgFromHistory = historyListener.findMessageById(1L);
        System.out.println("messageFromHistory: " + msgFromHistory.toString());
    }
}