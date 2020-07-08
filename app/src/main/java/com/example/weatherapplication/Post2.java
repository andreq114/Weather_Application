package com.example.weatherapplication;

import com.google.gson.annotations.SerializedName;

import static java.lang.Math.round;

public class Post2 {
    @SerializedName("main")
    private Post post;

    public String getTemp(){
        return String.valueOf(post.getTemp())+ " °C";
    }
    public String getTemp_min(){
        return String.valueOf(post.getTemp_min())+ " °C";
    }
    public String getTemp_max(){
        return String.valueOf(post.getTemp_max())+ " °C";
    }
    public String getPressure(){
        return String.valueOf(post.getPressure())+ " hPa";
    }
    public String getHumidity(){
        return String.valueOf(post.getHumidity())+ "%";
    }

    @SerializedName("wind")
    private Post post2;

    public String getSpeed(){
        return String.valueOf(round(post2.getSpeed()*3.6) + " km/h");
    }

    @SerializedName("weather")
    private Post[] post3;

    public String getDescription(){
        return post3[0].getDescription();
    }


}
