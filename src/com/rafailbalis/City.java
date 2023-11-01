package com.rafailbalis;

public class City {
    private String name;
    private String Country;
    private String Distinct;
    private Long Population;

    public City(String name, String country, String distinct, Long population) {
        this.name = name;
        Country = country;
        Distinct = distinct;
        Population = population;
    }

    public City() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getDistinct() {
        return Distinct;
    }

    public void setDistinct(String distinct) {
        Distinct = distinct;
    }

    public Long getPopulation() {
        return Population;
    }

    public void setPopulation(Long population) {
        Population = population;
    }

    @Override
    public String toString() {
        return name;
    }
}
