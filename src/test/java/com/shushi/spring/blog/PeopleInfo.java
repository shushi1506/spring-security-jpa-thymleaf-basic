package com.shushi.spring.blog;

/**
 * @author anhbt 8/30/2018
 * com.shushi.spring.blog
 */
public class PeopleInfo {
    private long females;
    private String country;
    private int age;
    private long males;
    private int year;
    private long total;

    public PeopleInfo(long females, String country, int age, long males, int year, long total) {
        this.females = females;
        this.country = country;
        this.age = age;
        this.males = males;
        this.year = year;
        this.total = total;
    }

    public PeopleInfo() {
    }

    public long getFemales() {
        return females;
    }

    public void setFemales(long females) {
        this.females = females;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getMales() {
        return males;
    }

    public void setMales(long males) {
        this.males = males;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PeopleInfo{" +
                "females=" + females +
                ", country='" + country + '\'' +
                ", age=" + age +
                ", males=" + males +
                ", year=" + year +
                ", total=" + total +
                '}';
    }
}
