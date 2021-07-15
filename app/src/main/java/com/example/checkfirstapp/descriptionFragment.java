package com.example.checkfirstapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link descriptionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class descriptionFragment extends Fragment {
    String name,branch,coll,exp;
    TextView t1,t2,t3,t4;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public descriptionFragment() {
        // Required empty public constructor
    }
    public descriptionFragment(String uname,String ubranch,String ucoll,String uexp) {

        name=uname;
        branch=ubranch;
        coll=ucoll;
        exp=uexp;
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment descriptionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static descriptionFragment newInstance(String param1, String param2) {
        descriptionFragment fragment = new descriptionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_description, container, false);

        t1=view.findViewById(R.id.us);
        t2=view.findViewById(R.id.bp);
        t3=view.findViewById(R.id.cc);
        t4=view.findViewById(R.id.decexp);
        t1.setText(name);
        t2.setText(branch);
        t3.setText(coll);
        t4.setText(exp);


        return view;
    }
}