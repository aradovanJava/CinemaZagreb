package hr.apisit.java.domain;

import java.util.List;

public class Stage {

    private Integer id;
    private String name;
    private List<Seat> setList;

    public Stage(Integer id, String name, List<Seat> setList) {
        this.id = id;
        this.name = name;
        this.setList = setList;
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

    public List<Seat> getSetList() {
        return setList;
    }

    public void setSetList(List<Seat> setList) {
        this.setList = setList;
    }

    @Override
    public String toString() {
        return name;
    }
}
