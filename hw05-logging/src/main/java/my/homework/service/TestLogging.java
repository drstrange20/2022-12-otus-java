package my.homework.service;

import my.homework.annotation.Log;
import my.homework.api.service.TestLoggingInterface;
import service.OutputService;

public class TestLogging implements TestLoggingInterface {
    OutputService outputService = new ConsoleOutputService();
    @Log
    @Override
    public void calculation(int param1) {
        outputService.outputMessage("calculation with param1 called\n");
    }

    @Override
    public void calculation(int param1, int param2) {
        outputService.outputMessage("calculation with param1, param2 called\n");
    }

    @Log
    @Override
    public void calculation(int param1, int param2, String param3) {
        outputService.outputMessage("calculation with param1, param2, param3 called\n");
    }
}