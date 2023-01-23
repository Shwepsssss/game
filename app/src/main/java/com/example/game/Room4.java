package com.example.game;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class Room4 extends AppCompatActivity {
    private boolean[] arr;
    private Chronometer chronometer;
    private boolean key = false;
    private Chronom c;
    private Code co;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room4);
        Bundle b = this.getIntent().getExtras();
        //bool
        key = b.getBoolean("key");
        //new arr = prev arr
        arr = b.getBooleanArray("arr");
        arr[3] = true;
        //stopwatch
        chronometer = findViewById(R.id.chronometer);
        c = b.getParcelable("p");
        c.start(chronometer);
        //code
        co = b.getParcelable("co");


    }

    public void room1(View view) {
        //stopwatch
        c.stop(chronometer);
        //read bundle
        Bundle b = new Bundle();
        System.out.println(Arrays.toString(arr));
        //bundle arr and long
        b.putBooleanArray("arr", arr);
        b.putBoolean("key", key);
        b.putParcelable("p", c);
        Intent intent = new Intent();
        intent.putExtras(b);
        //finish and send result
        setResult(RESULT_OK, intent);
        finish();
    }


    public void h(View view) {
        Bundle b = this.getIntent().getExtras();
        //System.out.println(Arrays.toString(arr));
        Hint hint = new Hint(arr, key);
        if (hint.roomCheck(this))
            if (hint.keyCheck(this))
                System.out.println("f");

    }

    public void closet1(View view) {
        ExampleDialog exampleDialog = new ExampleDialog(co,3);
        exampleDialog.show(getSupportFragmentManager(),"g");
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label", Integer.toBinaryString(co.getCode3()));
        clipboard.setPrimaryClip(clip);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999 && resultCode == RESULT_OK) {
            arr = data.getBooleanArrayExtra("arr");
            key = data.getBooleanExtra("key", key);
            c = data.getParcelableExtra("p");
            c.start(chronometer);


        }
    }
}