package com.example.game;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Random;

public class Code implements Parcelable {
    Random r = new Random();
    private int code1;
    private int code2;
    private int code3;
    private int code4;

    public Code() {
        this.code1 = r.nextInt(9)+1;
        this.code2 = r.nextInt(9)+1;
        this.code3 = r.nextInt(9)+1;
        this.code4 = r.nextInt(9)+1;
    }

    protected Code(Parcel in) {
        code1 = in.readInt();
        code2 = in.readInt();
        code3 = in.readInt();
        code4 = in.readInt();
    }

    public static final Creator<Code> CREATOR = new Creator<Code>() {
        @Override
        public Code createFromParcel(Parcel in) {
            return new Code(in);
        }

        @Override
        public Code[] newArray(int size) {
            return new Code[size];
        }
    };

    public int getCode1() {
        return code1;
    }

    public int getCode2() {
        return code2;
    }

    public int getCode3() {
        return code3;
    }

    public int getCode4() {
        return code4;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(code1);
        parcel.writeInt(code2);
        parcel.writeInt(code3);
        parcel.writeInt(code4);
    }


    public boolean enterCode(int code1,int code2,int code3,int code4){

        if (code1 == this.code1 && code2 == this.code2 && code3 == this.code3 && code4 == this.code4)
            return true;



        return false;
    }





}