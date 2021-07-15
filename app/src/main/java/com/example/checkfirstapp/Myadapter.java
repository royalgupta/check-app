package com.example.checkfirstapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Myadapter  extends RecyclerView.Adapter<Myadapter.viewHolder> {
    ArrayList<String> l=new ArrayList<String>();
    Context context;

    public Myadapter() {
    }

    public Myadapter(ArrayList<String> l) {
        this.l = l;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.design,parent,false);

        return new viewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        FragmentTransaction fragmentTransaction=((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();


        holder.t.setText(l.get(position));

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p=l.get(position);
                fragmentTransaction.replace(R.id.framelayout,new UserFragment(p));
                fragmentTransaction.commit();




            }
        });



    }

    @Override
    public int getItemCount() {

        return l.size();
    }


    public class  viewHolder extends RecyclerView.ViewHolder{

        TextView t;
        CardView card;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            t=itemView.findViewById(R.id.textview4);
            card=itemView.findViewById(R.id.designcard);


        }
    }
}
