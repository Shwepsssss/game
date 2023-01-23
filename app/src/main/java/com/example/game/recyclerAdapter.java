package com.example.game;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private LeaderB q;
    private LinkedHashMap<Long,String> scoreMapSorted = new LinkedHashMap<>();
    private ArrayList<Long> l = new ArrayList<>();
    private ArrayList<String> n = new ArrayList<>();


    public recyclerAdapter(LeaderB q,ArrayList<Long>l,ArrayList<String>n) {
        this.l = l;
        this.n = n;
        this.q = q;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
    private TextView username;
    private Chronometer ch;
    //private TextView score;


        public MyViewHolder(final View view){
        super(view);
        username = view.findViewById(R.id.textView);
        //score = view.findViewById(R.id.textView2);
        ch = view.findViewById(R.id.chronometer);




        }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        scoreMapSorted = q.getScoreMapSorted();
        for (Map.Entry<Long,String> e: scoreMapSorted.entrySet()){
            l.add(e.getKey());
            n.add(e.getValue());
        }
        String name = n.get(position);
        Long lo = l.get(position);
        holder.username.setText(name+", ");
        holder.ch.setBase(SystemClock.elapsedRealtime() - lo);


    }

    @Override
    public int getItemCount() {
        return n.size();
    }
}
