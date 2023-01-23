package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.anupkumarpanwar.scratchview.ScratchView;

import java.util.Arrays;

public class Room5 extends AppCompatActivity {
    private boolean [] arr;
    private Chronometer chronometer;
    private Chronom c;
    private boolean key = false;
    private Code co;
    TextView tvc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room5);
        tvc = (TextView) findViewById(R.id.tvc);

        ScratchView scratchView = findViewById(R.id.sv);
        Bundle b = this.getIntent().getExtras();
        // new arr = prev arr
        arr = b.getBooleanArray("arr");
        arr[4] = true;
        //stopwatch
        chronometer = findViewById(R.id.chronometer);
        c = b.getParcelable("p");
        c.start(chronometer);
        //key bool
        key = b.getBoolean("key");
        //code
        co = b.getParcelable("co");

        scratchView.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {
                tvc.setText(String.valueOf(co.getCode4()));
                ExampleDialog exampleDialog = new ExampleDialog(co,4);
                exampleDialog.show(getSupportFragmentManager(),"g");
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {
                if (percent>=0.5) {
                    Log.d("Reveal Percentage", "onRevealPercentChangedListener: " + String.valueOf(percent));
                }
            }
        });
    }

    public void room3(View view) {
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
        Hint hint = new Hint(arr,key);
        if (hint.roomCheck(this))
            if (hint.keyCheck(this))
                System.out.println("d");
    }

    public void pass(View view) {
        //stopwatch
        c.stop(chronometer);
        //read bundle
        Bundle b=this.getIntent().getExtras();
        b.putParcelable("p",c);
        b.putParcelable("co",co);
        Intent intent=new Intent(this, Pass.class);
        intent.putExtras(b);
        //start new activity
        startActivity(intent);
        c.start(chronometer);


    }
}

