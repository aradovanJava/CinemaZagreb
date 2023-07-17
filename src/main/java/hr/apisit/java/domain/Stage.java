package hr.apisit.java.domain;

import java.util.List;

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
}
