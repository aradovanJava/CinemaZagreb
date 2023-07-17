package hr.apisit.java.domain;

import java.util.List;

public class Cinema extends BaseEntity {

    private String name;
    private Address address;
    private List<Projection> projectionList;
    private List<Stage> stageList;

    public Cinema(Long id, String name, Address address, List<Projection> projectionList, List<Stage> stageList) {
        super(id);
        this.name = name;
        this.address = address;
        this.projectionList = projectionList;
        this.stageList = stageList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Projection> getProjectionList() {
        return projectionList;
    }

    public void setProjectionList(List<Projection> projectionList) {
        this.projectionList = projectionList;
    }

    public List<Stage> getStageList() {
        return stageList;
    }

    public void setStageList(List<Stage> stageList) {
        this.stageList = stageList;
    }

    @Override
    public String toString() {
        return name + " " + address;
    }
}
