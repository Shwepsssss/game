package com.example.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

public class LeaderBoard extends AppCompatActivity {
    private LeaderB q;
    private RecyclerView recyclerView;
    //private LinkedHashMap<Long,String> scoreMapSorted = new LinkedHashMap<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        recyclerView = findViewById(R.id.recyclerView);
        SharedPreferences sp = getApplicationContext().getSharedPreferences("sp", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sp.getString("json","");
        q = gson.fromJson(json, LeaderB.class);
        q.sort();
        setAdapter();
    }
    private void setAdapter() {
        recyclerAdapter adapter = new recyclerAdapter(q,q.getScoreMapSortedArrScore(),q.getScoreMapSortedArrString());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    public void main(View view) {
        finish();
    }


}