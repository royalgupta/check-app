package com.example.checkfirstapp;

public class model {

    String name,position,company,experince;

    public model() {
    }

    public model(String name, String position, String company, String experince) {
        this.name = name;
        this.position = position;
        this.company = company;
        this.experince = experince;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getExperince() {
        return experince;
    }

    public void setExperince(String experince) {
        this.experince = experince;
    }
}
