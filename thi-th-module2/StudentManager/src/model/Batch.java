package model;

public class Batch {
    private String batchId;
    private String name;
    private String teacherId;

    public Batch(String batchId, String name, String teacherId) {
        this.batchId =batchId;
        this.name = name;
        this.teacherId = teacherId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
