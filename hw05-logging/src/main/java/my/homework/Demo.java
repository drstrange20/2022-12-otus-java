package my.homework;


import my.homework.api.service.TestLoggingInterface;
import my.homework.service.Ioc;

public class Demo {
    public static void main(String[] args) throws Exception {
        TestLoggingInterface myClass = (TestLoggingInterface) Ioc.createMyClass("my.homework.service.TestLogging");
        myClass.calculation(1);
        myClass.calculation(1, 2);
        myClass.calculation(1, 2, "3");

    }
}