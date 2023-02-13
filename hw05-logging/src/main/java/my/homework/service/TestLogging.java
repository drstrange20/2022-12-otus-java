package my.homework.service;

import my.homework.annotation.Log;
import my.homework.api.service.TestLoggingInterface;
import service.OutputService;

public class TestLogging implements TestLoggingInterface {
    OutputService outputService = new ConsoleOutputService();
    @Log
    @Override
    public void calculation1(int param1) {
        outputService.outputMessage("calculation1 called");
    }

    @Log
    @Override
    public void calculation2(int param1, int param2) {
        outputService.outputMessage("calculation2 called");
    }

    @Log
    @Override
    public void calculation3(int param1, int param2, String param3) {
        outputService.outputMessage("calculation3 called");
    }
}