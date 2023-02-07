package ru.otus;

import com.google.common.collect.ImmutableList;
import service.OutputService;

import java.util.List;

public class HelloOtus {
    static OutputService outputService = new ConsoleOutputService();
    public static void main(String[] args) {
        List<String> list = ImmutableList.of("a", "b", "c");
        outputService.outputMessage(list.toString());
    }
}