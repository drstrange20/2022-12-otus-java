package ru.otus.dataprocessor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import ru.otus.model.Measurement;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ResourcesFileLoader implements Loader {
    private final String fileName;

    public ResourcesFileLoader(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public List<Measurement> load() {
        Gson gson = new Gson();
        List<Measurement> data = null;
        try (JsonReader reader = new JsonReader(new FileReader(getFileName()))) {
            data = gson.fromJson(reader, new TypeToken<List<Measurement>>() {}.getType());
        } catch (Exception e) {
            System.out.println("File not found");
        }
        return data;
    }
}