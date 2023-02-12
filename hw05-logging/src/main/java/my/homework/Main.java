package my.homework;
/*
Разработайте такой функционал:
        метод класса можно пометить самодельной аннотацией @Log, например, так:
class TestLogging implements TestLoggingInterface {
    @Log
    public void calculation(int param) {};
}
    При вызове этого метода "автомагически" в консоль должны логироваться значения параметров.
        Например так.
class Demo {
    public void action() {
        new TestLogging().calculation(6);
    }
}
    В консоле дожно быть:
        executed method: calculation, param: 6
        Обратите внимание: явного вызова логирования быть не должно.
        Учтите, что аннотацию можно поставить, например, на такие методы:
public void calculation(int param1)
public void calculation(int param1, int param2)
public void calculation(int param1, int param2, String param3)

*/

import my.homework.service.TestLogging;

public class Main {
    public static void main(String[] args) {
        TestLogging testLogging = new TestLogging();

        new TestLogging().calculation(5);
        new TestLogging().calculation(5, 5);
        new TestLogging().calculation(5, 5, "5");
    }
}
