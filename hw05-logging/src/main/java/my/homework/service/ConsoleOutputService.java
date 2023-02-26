package my.homework.service;

import service.ReportService;


public class ConsoleOutputService implements ReportService {
    @Override
    public void printReport(String method, String args) {
        if (args == null || args.equals("null")) {
            args = "there is no params in this method";
        }
        outputMessage("executed method: " + method + ", params: " + args);
    }
}