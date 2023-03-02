package my.homework.service;

import service.ReportService;


public class ConsoleOutputService implements ReportService {
    @Override
    public void printReport(String param1, String param2) {
        outputMessage("TOTAL NUMBER OF TESTS: " + param1);
        outputMessage("PASSED TESTS: " + (Integer.parseInt(param1) - Integer.parseInt(param2)));
        outputMessage("FAILED TESTS: " + param2);
    }
}