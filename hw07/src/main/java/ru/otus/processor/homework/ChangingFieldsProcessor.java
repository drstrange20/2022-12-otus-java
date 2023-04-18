package ru.otus.processor.homework;

import ru.otus.model.Message;
import ru.otus.processor.Processor;

public class ChangingFieldsProcessor implements Processor {
    @Override
    public Message process(Message message) {
        String field11 = message.getField11();

        return new Message.Builder(message.getId())
                .field1(message.getField1())
                .field2(message.getField2())
                .field3(message.getField3())
                .field4(message.getField4())
                .field5(message.getField5())
                .field6(message.getField6())
                .field7(message.getField7())
                .field8(message.getField8())
                .field9(message.getField9())
                .field10(message.getField10())
                .field11(message.getField12())
                .field12(field11)
                .field13(message.getField13())
                .build();
    }
}
