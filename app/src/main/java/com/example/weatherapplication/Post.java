package com.example.weatherapplication;


public class Post {

    private float temp;

    private int pressure ;

    private int humidity;

    private float temp_min ;

    private float temp_max ;

    private float speed;

    private String description;


    public String getDescription(){
        return description;
    }

    public float getSpeed() {
        return speed;
    }

    public float getTemp() {
        return temp;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }
}


