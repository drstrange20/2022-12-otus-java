package ru.otus.dataprocessor;


import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileSerializer implements Serializer {

    private final String fileName;
    public FileSerializer(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public void serialize(Map<String, Double> data) {
        Gson gson = new Gson();
        gson.toJson(data);

        try(FileWriter fileWriter = new FileWriter(getFileName())) {
            gson.toJson(data, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //формирует результирующий json и сохраняет его в файл
    }
}