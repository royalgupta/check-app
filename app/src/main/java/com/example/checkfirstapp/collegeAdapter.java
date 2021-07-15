package com.example.checkfirstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;

public class collegeAdapter extends  RecyclerView.Adapter<collegeAdapter.viewHolder> {

    ArrayList<String> arrayList=new ArrayList<String>();
    Context context;

    public collegeAdapter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public collegeAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();

        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.design,parent,false);

        return new collegeAdapter.viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull collegeAdapter.viewHolder holder, int position) {
        holder.t.setText(arrayList.get(position));
        FragmentTransaction fragmentTransaction= ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
        holder.card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String k= arrayList.get(position);
                fragmentTransaction.replace(R.id.framelayout,new StudentFragment(k)
                ).commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class viewHolder extends  RecyclerView.ViewHolder{
        TextView t;
        CardView card1;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            t=itemView.findViewById(R.id.textview4);
            card1=itemView.findViewById(R.id.designcard);

        }
    }
}
