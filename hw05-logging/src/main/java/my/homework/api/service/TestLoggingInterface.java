package my.homework.api.service;

import my.homework.annotation.Log;

public interface TestLoggingInterface {
    void calculation(int param1);
    void calculation(int param1, int param2);
    void calculation(int param1, int param2, String param3);
}
