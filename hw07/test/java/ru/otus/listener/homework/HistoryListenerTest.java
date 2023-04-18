package ru.otus.listener.homework;


import org.junit.jupiter.api.Test;
import ru.otus.model.Message;
import ru.otus.model.ObjectForMessage;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class HistoryListenerTest {

    @Test
    void listenerTest() {
        var historyListener = new HistoryListener();

        long id = 100L;
        String data = "33";
        ObjectForMessage objectForMessage = new ObjectForMessage();
        List<String> dataList = new ArrayList<>();
        dataList.add(data);
        objectForMessage.setData(dataList);

        var message = new Message.Builder(id)
                .field10("field10")
                .field13(objectForMessage)
                .build();

        historyListener.onUpdated(message);
        message.getField13().setData(new ArrayList<>());
        dataList.clear();

        var messageFromHistory = historyListener.findMessageById(id);
        assertThat(messageFromHistory).isPresent();
        assertThat(messageFromHistory.get().getField13().getData()).containsExactly(data);
    }
}