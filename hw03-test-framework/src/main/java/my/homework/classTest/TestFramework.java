package my.homework.classTest;

import my.homework.annotations.After;
import my.homework.annotations.Before;
import my.homework.annotations.Test;
import my.homework.service.ConsoleOutputService;
import service.OutputService;

public class TestFramework {
    OutputService outputService = new ConsoleOutputService();

    @Before
    public void beforeMethod() {
        outputService.outputMessage("beforeMethod() called");
    }

    @Test
    public void test1Method() {
        outputService.outputMessage("this test passed");
    }

    @Test
    public void test2Method() {
        outputService.outputMessage("this test failed");
        throw new RuntimeException();
    }

    @Test
    public void test3Method() {
        outputService.outputMessage("this test failed");
        throw new RuntimeException();
    }

    @After
    public void afterMethod() {
        outputService.outputMessage("afterMethod() called\n");
    }
}