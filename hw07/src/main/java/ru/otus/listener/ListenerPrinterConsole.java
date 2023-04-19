package ru.otus.listener;

import ru.otus.model.Message;

public class ListenerPrinterConsole implements Listener {

    @Override
    public void onUpdated(Message msg) {
        var logString = String.format("oldMsg:                    %s", msg); //Для того чтобы в консоли было нагляднее
        System.out.println(logString);
    }
}
