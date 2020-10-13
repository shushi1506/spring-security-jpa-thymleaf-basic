package com.shushi.spring.blog.results;

/**
 * @author anhbt 8/1/2018
 * com.shushi.spring.blog.results
 */
public class ResultPercentSystem {
    private Double y;
    private String label;

    public ResultPercentSystem() {
    }

    public ResultPercentSystem(Double y, String label) {
        this.y = y;
        if(label== null || label.equals("null")){
            this.label="Other";
        }else this.label = label;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "ResultPercentSystem{" +
                "y=" + y +
                ", label='" + label + '\'' +
                '}';
    }
}
