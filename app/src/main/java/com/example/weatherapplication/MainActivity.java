package com.example.weatherapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();
    }
    public void checkWeather(View view){
        TextView city = findViewById(R.id.editText);
        String cityText = city.getText().toString();
        saveData(cityText);
        Intent intent = new Intent(this,WeatherActivity.class);
        intent.putExtra("KEY1",cityText);
        startActivity(intent);
    }
    private void saveData(String output){
        SharedPreferences sharedPreferences = getSharedPreferences("city",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("KEY2",output);
        editor.apply();
    }
    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("city",MODE_PRIVATE);
        String cityText = sharedPreferences.getString("KEY2","");
        TextView cityName = findViewById(R.id.editText);
        cityName.setText(cityText);
    }
}
