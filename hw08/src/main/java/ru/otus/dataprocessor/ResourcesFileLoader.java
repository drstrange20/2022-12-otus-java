package ru.otus.dataprocessor;

import com.google.gson.Gson;
import ru.otus.model.Measurement;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Objects;

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
        try (Reader reader = new InputStreamReader(Objects.requireNonNull(ResourcesFileLoader.class.getClassLoader()
                .getResourceAsStream(getFileName())))) {
            return List.of(new Gson().fromJson(reader, Measurement[].class));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
