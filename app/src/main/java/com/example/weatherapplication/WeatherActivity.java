package com.example.weatherapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Icon;
import android.graphics.drawable.PictureDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Url;

import static java.lang.System.exit;

public class WeatherActivity extends AppCompatActivity {
    private String miasto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);


        TextView cityText = findViewById(R.id.city2);
        final Intent intent = getIntent();                                 //MIASTO
        miasto = intent.getStringExtra("KEY1");
        cityText.setText(miasto);


        Date now = new Date();
        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm"); //GODZINA
        String godzina = sdfDate.format(now);
        TextView time = findViewById(R.id.time);
        time.setText(godzina);




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceholderAPI jsonPlaceholderAPI = retrofit.create(JsonPlaceholderAPI.class);

        Call<Post2> call = jsonPlaceholderAPI.getPosts(miasto+",pl","749561a315b14523a8f5f1ef95e45864","metric");

        call.enqueue(new Callback<Post2>() {
            @Override
            public void onResponse(Call<Post2> call, Response<Post2> response) {

                if (!response.isSuccessful()){
                    finish();
                }
                else {
                    Post2 posts = response.body();

                    TextView tempMax = findViewById(R.id.tempMax);
                    TextView tempMin = findViewById(R.id.tempMin);
                    TextView pressure = findViewById(R.id.cisnienie);
                    TextView humidity = findViewById(R.id.wilgotnosc);
                    TextView temp = findViewById(R.id.temp);
                    TextView wind = findViewById(R.id.wind);
                    TextView description = findViewById(R.id.weather);

                    tempMax.setText(posts.getTemp_max());
                    tempMin.setText(posts.getTemp_min());
                    pressure.setText(posts.getPressure());
                    humidity.setText(posts.getHumidity());
                    temp.setText(posts.getTemp());
                    wind.setText(posts.getSpeed());
                    description.setText(posts.getDescription());
                }


            }
            @Override
            public void onFailure(Call<Post2> call, Throwable t) {
                finish();
            }
        });

    }
    public void changeCity(View view){
        finish();
    }

}
