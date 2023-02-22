package my.homework;
/*
Здравствуйте!
        Стало гораздо универсальнее. Правда будут проблемы - если мы более одного инстанса класса
        попробуем создать. Количество методов в массиве для поиска с каждый инстансом будет расти.
        если у нас будет несколько разных классов - то и они все будут в одном массиве. АА если в
        разных классах совпадут сигнатуры методов - то вообще будут забавные призраки в поведении.
        Статика - опасный инструмент, стоит минимизировать её применение. Давайте сделаем теперь
        ещё быстрее и безопаснее

        fullScan - довольно медленно. Есть более быстрые конструкции для поиска*/

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