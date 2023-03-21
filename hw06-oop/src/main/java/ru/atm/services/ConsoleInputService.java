package ru.atm.services;

import service.InputService;

import java.util.Scanner;

public class ConsoleInputService implements InputService {
    private final Scanner in;

    public ConsoleInputService() {
        this.in = new Scanner(System.in);
    }

    @Override
    public int readInt() {
        return in.nextInt();
    }

    @Override
    public String readString() {
        return in.nextLine();
    }
}
