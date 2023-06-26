package hr.apisit.java.domain;

public enum City {

    ZAGREB("ZAGREB"), SPLIT("SPLIT"),
    RIJEKA("RIJEKA"), OSIJEK("OSIJEK"),
    VARAZDIN("VARAŽDIN"), CAKOVEC("ČAKOVEC");

    private String cityName;

    private City(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return this.cityName;
    }
}
