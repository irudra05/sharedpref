package com.example.sharedprferences201b352;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    TextView textview;
    SharedPreferences sharedPreferences;
    String [] winnerArray = {"Rahul","Rohan","Priya"};

    public void storedPreferences(View view){
        sharedPreferences.edit().putString("players", new Gson().toJson(winnerArray)).apply();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview=findViewById(R.id.textview);
        sharedPreferences=this.getSharedPreferences("com.example.sharedprferences201b352", Context.MODE_PRIVATE);
        String [] temp=new Gson().fromJson(sharedPreferences.getString("players",null),winnerArray.getClass());
        textview.setText(Arrays.toString(temp));
    }
}