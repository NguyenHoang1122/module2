package service;

import model.Batch;
import util.CSVUtil;

import java.util.ArrayList;
import java.util.List;

public class BatchService {
    private final List<Batch> batchList = new ArrayList<>();

    public BatchService() {
        loadFromFile();
    }

    private void loadFromFile() {
        List<String[]> data = CSVUtil.readCSV("data/batch.csv");
        for (String[] row : data) {
            if (row.length == 3) {
                Batch batch = new Batch(row[0], row[1], row[2]);
                batchList.add(batch);
            }
        }
    }

    public boolean exists(String batchId) {
        return batchList.stream().anyMatch(batch -> batch.getBatchId().equals(batchId));
    }

    public String getBatchNameById(String batchId) {
        return batchList.stream()
                .filter(b -> b.getBatchId().equals(batchId))
                .map(Batch::getName)
                .findFirst()
                .orElse("Không xác định");
    }
}
