package ru.otus.dataprocessor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import ru.otus.model.Measurement;

import java.io.FileReader;
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
        List<Measurement> data = null;
        try (JsonReader reader = new JsonReader(new FileReader(getFileName()))) {
            data = new Gson().fromJson(reader, new TypeToken<List<Measurement>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}