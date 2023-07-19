package hr.apisit.java.domain;

import java.util.List;
import java.util.Objects;

public class Stage extends BaseEntity {
    private String name;
    private List<Seat> seatList;

    public Stage(Long id, String name, List<Seat> setList) {
        super(id);
        this.name = name;
        this.seatList = setList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stage stage)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(name, stage.name) && Objects.equals(seatList, stage.seatList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, seatList);
    }
}
