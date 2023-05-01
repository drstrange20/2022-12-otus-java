package ru.otus.dataprocessor;

import ru.otus.model.Measurement;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProcessorAggregator implements Processor {
    @Override
    public Map<String, Double> process(List<Measurement> data) {
        Map<String, Double> aggregatedMeasurements = new TreeMap<>();
        for (var i = 0; i < data.size(); i++) {
            if (aggregatedMeasurements.containsKey(data.get(i).getName())) {
                aggregatedMeasurements.replace(data.get(i).getName(), aggregatedMeasurements.get(data.get(i).getName()) + data.get(i).getValue());
            } else {
                aggregatedMeasurements.put(data.get(i).getName(), data.get(i).getValue());
            }
        }
        return aggregatedMeasurements;
    }
}
