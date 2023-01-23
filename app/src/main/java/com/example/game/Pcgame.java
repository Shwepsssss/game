package com.example.game;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class Pcgame extends AppCompatActivity {

    //my touch

    private boolean left = true;
    private boolean right = true;
    private boolean up = true;
    private boolean down = true;
    private int x = 10;
    private Code co;


    // Screen Size
    private int screenWidth;
    private int screenHeight;

    // Images
    private ImageView arrowUp;
    private ImageView arrowDown;
    private ImageView arrowRight;
    private ImageView arrowLeft;


    // Position
    private float arrowUpX;
    private float arrowUpY;
    private float arrowDownX;
    private float arrowDownY;
    private float arrowRightX;
    private float arrowRightY;
    private float arrowLeftX;
    private float arrowLeftY;

    // Initialize Class
    private Handler handler = new Handler();
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcgame);

        Bundle b = this.getIntent().getExtras();
        co = b.getParcelable("co");

        arrowUp = (ImageButton)findViewById(R.id.arrowUp);
        arrowDown = (ImageButton)findViewById(R.id.arrowDown);
        arrowRight = (ImageButton)findViewById(R.id.arrowRight);
        arrowLeft = (ImageButton)findViewById(R.id.arrowLeft);


        // Get Screen Size.
        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        // Move to out of screen.
        arrowUp.setX(-80.0f);
        arrowUp.setY(-80.0f);
        arrowDown.setX(-80.0f);
        arrowDown.setY(screenHeight + 80.0f);
        arrowRight.setX(screenWidth + 80.0f);
        arrowRight.setY(-80.0f);
        arrowLeft.setX(-80.0f);
        arrowLeft.setY(-80.0f);


        // Start the timer.
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        changePos();
                    }
                });
            }
        }, 0, 20);

    }

    public void changePos() {
        // Up
        arrowUpY -= x;
        if (arrowUp.getY() + arrowUp.getHeight() < 0) {
            arrowUpX = (float)Math.floor(Math.random() * (screenWidth - arrowUp.getWidth()));
            arrowUpY = screenHeight + 100.0f;
        }
        arrowUp.setX(arrowUpX);
        arrowUp.setY(arrowUpY);

        // Down
        arrowDownY += x;
        if (arrowDown.getY() > screenHeight) {
            arrowDownX = (float)Math.floor(Math.random() * (screenWidth - arrowDown.getWidth()));
            arrowDownY = -100.0f;
        }
        arrowDown.setX(arrowDownX);
        arrowDown.setY(arrowDownY);

        // Right
        arrowRightX += x;
        if (arrowRight.getX() > screenWidth) {
            arrowRightX = -100.0f;
            arrowRightY = (float)Math.floor(Math.random() * (screenHeight - arrowRight.getHeight()));
        }
        arrowRight.setX(arrowRightX);
        arrowRight.setY(arrowRightY);

        // Left
        arrowLeftX -= x;
        if (arrowLeft.getX() + arrowLeft.getWidth() < 0) {
            arrowLeftX = screenWidth + 100.0f;
            arrowLeftY = (float)Math.floor(Math.random() * (screenHeight - arrowLeft.getHeight()));
        }
        arrowLeft.setX(arrowLeftX);
        arrowLeft.setY(arrowLeftY);

        if (!left && !right && !up && !down){

                timer.cancel();
                timer = null;
            ExampleDialog exampleDialog = new ExampleDialog(co,2);
            exampleDialog.show(getSupportFragmentManager(),"g");
           }
        }




    public void left(View view) {
        left = false;
    }
    public void right(View view) {
        right = false;
    }
    public void up(View view) {
        up = false;
    }
    public void down(View view) {
        down = false;
    }

    public void room3(View view) {
        finish();
    }
}

