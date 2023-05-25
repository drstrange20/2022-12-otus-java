package service;

import java.io.PrintStream;

public interface OutputService {
    PrintStream out = System.out;

    default void outputMessage(String message) {
        out.println(message);
    }

}
