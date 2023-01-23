package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Pass extends AppCompatActivity {
    private Code co;
    private Chronom c;
    private EditText c1;
    private EditText c2;
    private EditText c3;
    private EditText c4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);
        Bundle b = this.getIntent().getExtras();
        co = b.getParcelable("co");
        c = b.getParcelable("p");
        c1 = (EditText) findViewById(R.id.c1);
        c2 = (EditText) findViewById(R.id.c2);
        c3 = (EditText) findViewById(R.id.c3);
        c4 = (EditText) findViewById(R.id.c4);
    }

    public void submit(View view) {
        int co1 = Integer.parseInt(c1.getText().toString());
        int co2 = Integer.parseInt(c2.getText().toString());
        int co3 = Integer.parseInt(c3.getText().toString());
        int co4 = Integer.parseInt(c4.getText().toString());

        if (co.enterCode(co1,co2,co3,co4)){
            Bundle b=this.getIntent().getExtras();
            b.putParcelable("p",c);
            Intent intent=new Intent(this, Finish.class);
            intent.putExtras(b);
            //start new activity
            startActivity(intent);
        }
            else{
                Toast.makeText(this, "Wrong code try again", Toast.LENGTH_SHORT).show();
            }



    }

    public void room5(View view) {
        finish();
    }
}