package ru.otus;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class HelloOtus {
    public static void main(String[] args) {
        List<String> list = ImmutableList.of("a", "b", "c");
        System.out.println(list);
    }
}