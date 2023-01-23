package com.example.game;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class Finish extends AppCompatActivity {
    private Chronom c;
    private EditText et1;
    private String username;
    private Button b1;
    SharedPreferences sp;
    private LeaderB q = new LeaderB();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        et1 = (EditText) findViewById(R.id.et1);
        b1 = (Button) findViewById(R.id.b1);
        Bundle b = this.getIntent().getExtras();
        c = b.getParcelable("p");
        sp = getSharedPreferences("sp", Context.MODE_PRIVATE);






    }

    public void submit(View view) {
        String json = sp.getString("json","");
        Gson gson = new Gson();
        q = gson.fromJson(json, LeaderB.class);
        username = et1.getText().toString();
        q.addScore(c.getPauseOffset(),username);
        SharedPreferences.Editor ed = sp.edit();
        json = gson.toJson(q);
        ed.putString("json",json);
        ed.commit();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}