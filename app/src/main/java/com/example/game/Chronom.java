package com.example.game;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class Chronom implements Parcelable {

    private long pauseOffset;

    public Chronom(long pauseOffset) {
        this.pauseOffset = pauseOffset;
    }

    protected Chronom(Parcel in) {
        pauseOffset = in.readLong();
    }

    public static final Creator<Chronom> CREATOR = new Creator<Chronom>() {
        @Override
        public Chronom createFromParcel(Parcel in) {
            return new Chronom(in);
        }

        @Override
        public Chronom[] newArray(int size) {
            return new Chronom[size];
        }
    };

    public long getPauseOffset() {
        return pauseOffset;
    }

    public void setPauseOffset(long pauseOffset) {
        this.pauseOffset = pauseOffset;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(pauseOffset);
    }

    public void start(Chronometer chronometer){
        chronometer.setFormat("Time: %s");
        chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
        chronometer.start();
    }

    public void stop(Chronometer chronometer){
        chronometer.stop();
        pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
    }

}
