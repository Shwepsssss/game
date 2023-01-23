package com.example.game;

import android.app.Activity;
import android.widget.Toast;

public class Hint {
    private boolean [] arr;

    private boolean key;

    public Hint(boolean [] arr,boolean key) {
        this.arr = arr;
        this.key = key;

    }


    public boolean roomCheck(Activity a) {
        for (int i = 0; arr.length>i;i++){
            if (!arr[i]){
                Toast.makeText(a, "find all rooms", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }

    public boolean keyCheck(Activity a) {
        if (!key){
            Toast.makeText(a, "Find keys to find the next code", Toast.LENGTH_SHORT).show();
        return false;
        }
        return true;
    }



}
