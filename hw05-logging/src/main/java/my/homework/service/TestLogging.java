package my.homework.service;

import my.homework.annotation.Log;
import my.homework.api.service.TestLoggingInterface;
import service.OutputService;

public class TestLogging implements TestLoggingInterface {
    private final OutputService outputService = new ConsoleOutputService();
    @Log
    @Override
    public void calculation(int param1) {
        outputService.outputMessage("method calculation with param " + param1 + " called\n");
    }

    @Override
    public void calculation(int param1, int param2) {
        outputService.outputMessage("other method called (there is no logging here)\n");
    }

    @Log
    @Override
    public void calculation(int param1, int param2, String param3) {
        outputService.outputMessage("method calculation with param " + param1 + ", " + param2 + ", " + param3 + ", called\n");
    }

    @Log
    @Override
    public void calculation() {
        outputService.outputMessage("method with empty params called\n");
    }
}