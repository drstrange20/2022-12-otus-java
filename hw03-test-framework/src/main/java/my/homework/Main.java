package my.homework;

import my.homework.classTest.TestRunner;


public class Main {
    public static void main(String[] args) throws Exception {
        TestRunner testRunner = new TestRunner();
        testRunner.run("my.homework.classTest.TestFramework");
    }
}