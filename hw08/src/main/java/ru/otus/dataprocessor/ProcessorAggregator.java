package ru.otus.dataprocessor;

import ru.otus.model.Measurement;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProcessorAggregator implements Processor {
    @Override
    public Map<String, Double> process(List<Measurement> data) {
        Map<String, Double> aggregatedMeasurements = new TreeMap<>();
        for (Measurement measurement : data) {
            aggregatedMeasurements.compute(measurement.getName(), (key, value) -> (value == null) ? measurement.getValue() : value + measurement.getValue());
        }
        return aggregatedMeasurements;
    }
}
