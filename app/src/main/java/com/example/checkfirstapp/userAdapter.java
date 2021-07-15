package com.example.checkfirstapp;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class userAdapter extends RecyclerView.Adapter<userAdapter.viewHolder2> {
    ArrayList<model> al=new ArrayList<model>();
    CardView carduser;
    Context context;

    public userAdapter(ArrayList<model> al) {
        this.al = al;
    }

    @NonNull
    @Override
    public viewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.userlayoutdesign,parent,false);
        return new viewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder2 holder, int position) {
        FragmentTransaction fra=((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
        holder.t1.setText(al.get(position).getName());
        holder.t2.setText(al.get(position).getPosition());
        carduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fra.replace(R.id.framelayout,new descriptionFragment(al.get(position).getName(),al.get(position).getPosition(),al.get(position).getCompany(),al.get(position).getExperince()));
                fra.commit();

            }
        });


    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class viewHolder2 extends RecyclerView.ViewHolder{


        TextView t1,t2;

        public viewHolder2(@NonNull View itemView) {
            super(itemView);

            t1=itemView.findViewById(R.id.user1);
            t2=itemView.findViewById(R.id.position1);
            carduser=itemView.findViewById(R.id.usercard);



        }
    }
}
