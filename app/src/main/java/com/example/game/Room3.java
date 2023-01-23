package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class Room3 extends AppCompatActivity {
    private boolean [] arr;
    private Chronometer chronometer;
    private Chronom c;
    private boolean key = false;
    private Code co;
    private LinearLayout myLayout;
    private Button b1;
    private Button b2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room3);
        Bundle b = this.getIntent().getExtras();
        // new arr = prev arr
        arr = b.getBooleanArray("arr");
        arr[2] = true;
        //stopwatch
        chronometer = findViewById(R.id.chronometer);
        c = b.getParcelable("p");
        c.start(chronometer);
        //key bool
        key = b.getBoolean("key");
        //button
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        //code
        co = b.getParcelable("co");
    }



    public void room2(View view) {
        //stopwatch
        c.stop(chronometer);
        //read bundle
        Bundle b = new Bundle();
        System.out.println(Arrays.toString(arr));
        //bundle arr and long
        b.putBooleanArray("arr", arr);
        b.putParcelable("p",c);
        b.putBoolean("key",key);
        Intent intent=new Intent();
        intent.putExtras(b);
        //finish and send result
        setResult(RESULT_OK,intent);
        finish();

    }

    public void h(View view) {
        Bundle b = this.getIntent().getExtras();
        System.out.println(Arrays.toString(arr));
        Hint hint = new Hint(arr,key);
        if (hint.roomCheck(this))
            if (hint.keyCheck(this))
                System.out.println("d");
    }

    public void pcgame(View view) {
        Bundle b = new Bundle();
        c.stop(chronometer);
        b.putParcelable("co",co);
        Intent intent = new Intent(this, Pcgame.class);
        intent.putExtras(b);
        startActivity(intent);
        c.start(chronometer);


    }

    public void room5(View view) {
        //stopwatch
        c.stop(chronometer);
        //read bundle
        Bundle b=this.getIntent().getExtras();
        System.out.println(Arrays.toString(arr));
        //send arr and long and bool
        b.putBooleanArray("arr", arr);
        b.putParcelable("p",c);
        b.putParcelable("co",co);
        b.putBoolean("key",key);
        Intent intent=new Intent(this, Room5.class);
        intent.putExtras(b);
        //start new activity
        startActivityForResult(intent,999);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999 && resultCode == RESULT_OK) {
                arr = data.getBooleanArrayExtra("arr");
                key = data.getBooleanExtra("key",key);
                c = data.getParcelableExtra("p");
                c.start(chronometer);


        }


    }


    public void keys(View view) {
        Toast.makeText(Room3.this, "you found a key now try to open something with it", Toast.LENGTH_SHORT).show();
        key = true;
    }
}