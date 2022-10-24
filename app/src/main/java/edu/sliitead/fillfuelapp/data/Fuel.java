package edu.sliitead.fillfuelapp.data;

public class Fuel {

    private String name;
    private Boolean status;

    public Fuel(String name) {
        this.name = name;
        this.status = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
