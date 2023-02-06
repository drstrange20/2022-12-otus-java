package my.homework.service;

import java.io.PrintStream;

public class ConsoleOutputService implements OutputService{
    private final PrintStream out;

    public ConsoleOutputService() {
        out = System.out;
    }

    @Override
    public void outputMessage(String message) {
        out.println(message);
    }

    @Override
    public void outputReport(int numberOfTests, int numberOfFailedTests) {
        outputMessage("TOTAL NUMBER OF TESTS: " + numberOfTests);
        outputMessage("PASSED TESTS: " + (numberOfTests - numberOfFailedTests));
        outputMessage("FAILED TESTS: " + numberOfFailedTests);
    }
}