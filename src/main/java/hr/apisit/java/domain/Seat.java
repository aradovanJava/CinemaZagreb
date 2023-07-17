package hr.apisit.java.domain;

public class Seat extends BaseEntity {

    private String rowName;
    private Integer positionInRow;

    public Seat(Long id, String rowName, Integer positionInRow) {
        super(id);
        this.rowName = rowName;
        this.positionInRow = positionInRow;
    }

    public String getRowName() {
        return rowName;
    }

    public void setRowName(String rowName) {
        this.rowName = rowName;
    }

    public Integer getPositionInRow() {
        return positionInRow;
    }

    public void setPositionInRow(Integer positionInRow) {
        this.positionInRow = positionInRow;
    }

    @Override
    public String toString() {
        return rowName + " " + positionInRow;
    }
}
