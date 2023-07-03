package hr.apisit.java.domain;

import java.util.List;

public class Stage {

    private Integer id;
    private String name;
    private List<Seat> seatList;

    public Stage(Integer id, String name, List<Seat> setList) {
        this.id = id;
        this.name = name;
        this.seatList = setList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
