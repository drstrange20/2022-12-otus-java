package my.homework.service;

import my.homework.annotation.Log;
import my.homework.api.services.TestLoggingInterface;

public class TestLogging implements TestLoggingInterface {
    @Log
    @Override
    public void calculation(int param1) {

    }

    @Log
    @Override
    public void calculation(int param1, int param2) {

    }

    @Log
    @Override
    public void calculation(int param1, int param2, String param3) {

    }
}
