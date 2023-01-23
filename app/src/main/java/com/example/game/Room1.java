package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class Room1 extends AppCompatActivity {
    private boolean [] arr;
    private Chronometer chronometer;
    private boolean key = false;
    private long p;
    private Chronom c = new Chronom(p);
    private Code co = new Code();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room1);
        //stopwatch
        chronometer = findViewById(R.id.chronometer);
        c.start(chronometer);
        //new arr = prev arr
        Bundle b = this.getIntent().getExtras();
        arr = b.getBooleanArray("arr");

        System.out.println(co.getCode1()+","+co.getCode2()+","+co.getCode3()+","+co.getCode4());
    }

    public void room2(View view) {
        //stopwatch
        c.stop(chronometer);
        //read bundle
        Bundle b = new Bundle();
        System.out.println(Arrays.toString(arr));
        //send arr and long
        b.putBooleanArray("arr", arr);
        b.putParcelable("p",c);
        b.putParcelable("co",co);
        b.putBoolean("key",key);
        Intent intent = new Intent(this, Room2.class);
        intent.putExtras(b);
        //start new activity
        startActivityForResult(intent, 999);
    }

    public void room4(View view) {
        //stopwatch
        c.stop(chronometer);
        //read bundle
        Bundle b = this.getIntent().getExtras();
        System.out.println(Arrays.toString(arr));
        //send arr and start it
        b.putBooleanArray("arr", arr);
        b.putBoolean("key",key);
        b.putParcelable("p",c);
        b.putParcelable("co",co);
        Intent intent = new Intent(this, Room4.class);
        intent.putExtras(b);
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

    public void h(View view) {
            Hint hint = new Hint(arr,key);
            if (hint.roomCheck(this))
                if (hint.keyCheck(this))
                    System.out.println("d");


        }
    }
