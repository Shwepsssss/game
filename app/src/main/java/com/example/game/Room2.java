package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class Room2 extends AppCompatActivity {
    private boolean [] arr;
    private Chronometer chronometer;
    private Chronom c;
    private boolean key = false;
    private Code co;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room2);
        Bundle b = this.getIntent().getExtras();
        //new arr = prev arr
        arr = b.getBooleanArray("arr");
        arr[1] = true;
        //stopwatch
        chronometer = findViewById(R.id.chronometer);
        c = b.getParcelable("p");
        c.start(chronometer);
        //key bool
        key = b.getBoolean("key");
        //code
        co = b.getParcelable("co");






    }

    public void room3(View view) {
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
        Intent intent=new Intent(this, Room3.class);
        intent.putExtras(b);
        //start new activity
        startActivityForResult(intent,999);


    }

    public void room1(View view) {
        //stopwatch
        c.stop(chronometer);
        //read bundle
        Bundle b = new Bundle();
        System.out.println(Arrays.toString(arr));
        //Bundle arr and long
        b.putBooleanArray("arr", arr);
        b.putBoolean("key",key);
        b.putParcelable("p",c);
        Intent intent=new Intent();
        intent.putExtras(b);
        //finish activity and send result
        setResult(RESULT_OK,intent);
        finish();


    }

    public void drawer1(View view) {
        if (key) {
            Bundle b = new Bundle();
            b.putParcelable("co",co);
            ExampleDialog exampleDialog = new ExampleDialog(co,1);
            exampleDialog.show(getSupportFragmentManager(),"g");
        }
        else
            Toast.makeText(this, "try to find keys to open the drawer", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999 && resultCode == RESULT_OK){
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