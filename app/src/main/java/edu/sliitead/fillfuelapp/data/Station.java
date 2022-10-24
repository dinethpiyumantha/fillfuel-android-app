package edu.sliitead.fillfuelapp.data;

public class Station {
    private String name;
    private String company;
    private String address;

    public Station(String name, String company, String address) {
        this.name = name;
        this.company = company;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
