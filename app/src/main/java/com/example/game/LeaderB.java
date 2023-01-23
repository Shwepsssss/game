package com.example.game;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class LeaderB implements Parcelable {
    private LinkedHashMap<Long,String> scoreMap = new LinkedHashMap<>();
    private LinkedHashMap <Long,String> scoreMapSorted = new LinkedHashMap<>();


    public LeaderB() {
    }

    protected LeaderB(Parcel in) {
    }

    public static final Creator<LeaderB> CREATOR = new Creator<LeaderB>() {
        @Override
        public LeaderB createFromParcel(Parcel in) {
            return new LeaderB(in);
        }

        @Override
        public LeaderB[] newArray(int size) {
            return new LeaderB[size];
        }
    };

    public void sort(){
        if (!scoreMap.isEmpty())
        scoreMapSorted.clear();
        Map<Long, String> map = new TreeMap<>(scoreMap);
        for (Long sKey : map.keySet()) {
            System.out.println("Key -> " + sKey
                    + ":  Value -> "
                    + scoreMap.get(sKey));
            scoreMapSorted.put(sKey,scoreMap.get(sKey));


        }



    }

    public void addScore(Long l,String n) {
        scoreMap.put(l,n);
    }

    public LinkedHashMap<Long, String> getScoreMap() {
        return scoreMap;
    }

    public void print(){
        for (Map.Entry<Long,String> e: scoreMapSorted.entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue());

        }





    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }


    public LinkedHashMap<Long, String> getScoreMapSorted() {
        return scoreMapSorted;
    }


    public ArrayList<String> getScoreMapSortedArrString(){
        ArrayList<String> username = new ArrayList<>();
        for (Map.Entry<Long,String> e: scoreMapSorted.entrySet()){
            username.add(e.getValue());
        }

        return username;
    }

    public ArrayList<Long> getScoreMapSortedArrScore(){
        ArrayList<Long> score = new ArrayList<>();
        for (Map.Entry<Long,String> e: scoreMapSorted.entrySet()){
            score.add(e.getKey());
        }

        return score;
    }

    public boolean isEmpty(){

        return scoreMap.isEmpty();
    }



}
