package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }




    public void room1(View view) {

        Bundle b=new Bundle();
        b.putBooleanArray("arr", new boolean[]{true,false,false,false,false});
        Intent intent=new Intent(this, Room1.class);
        intent.putExtras(b);
        startActivity(intent);

    }


    public void leaderboard(View view) {
        Intent intent = new Intent(this,LeaderBoard.class);
        startActivity(intent);


}

    public void instructions(View view) {
        Intent intent = new Intent(this,Instructions.class);
        startActivity(intent);
    }
}