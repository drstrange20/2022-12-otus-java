package service;


import java.util.Scanner;

public interface InputService {
    Scanner in = new Scanner(System.in);

    default int readInt() {
        return in.nextInt();
    }

    default String readString() {
        return in.nextLine();
    }
}
