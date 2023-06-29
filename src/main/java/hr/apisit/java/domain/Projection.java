package hr.apisit.java.domain;

import java.time.LocalDateTime;

public class Projection {

    private Long id;
    private String name;
    private LocalDateTime dateTime;
    private Stage stage;

    public Projection(Long id, String name, LocalDateTime dateTime, Stage stage) {
        this.id = id;
        this.name = name;
        this.dateTime = dateTime;
        this.stage = stage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public String toString() {
        return name + " " + dateTime + " " + stage;
    }
}
