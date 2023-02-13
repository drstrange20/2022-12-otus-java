package my.homework.service;

public class Demo {
    public void action() {
        new TestLogging().calculation(1);
        new TestLogging().calculation(1, 2);
        new TestLogging().calculation(1, 2, "3");
    }
}
