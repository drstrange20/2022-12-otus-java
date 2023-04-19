package ru.otus.processor.homework;


import ru.otus.model.Message;
import ru.otus.processor.Processor;

public class ExceptionProcessor implements Processor {
    private final DateTimeProvider dateTimeProvider;

    public ExceptionProcessor(DateTimeProvider dateTimeProvider) {
        this.dateTimeProvider = dateTimeProvider;
    }

    private DateTimeProvider getDateTimeProvider() {
        return dateTimeProvider;
    }

    @Override
    public Message process(Message message) {
        if (getDateTimeProvider().getSecond() % 2 == 0) {
            System.err.println("Exception thrown");
            throw new RuntimeException();
        }
        return message;
    }
}
