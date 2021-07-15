package com.example.checkfirstapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddCompanyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddCompanyFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button addcollege,reg;
    ScrollView scrollView;
    TextInputLayout  uname,pos,comname,exp;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddCompanyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddCompanyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddCompanyFragment newInstance(String param1, String param2) {
        AddCompanyFragment fragment = new AddCompanyFragment();
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
        FragmentTransaction frag=getActivity().getSupportFragmentManager().beginTransaction();
        View view= inflater.inflate(R.layout.fragment_add_company, container, false);
        //hooks

        uname=(TextInputLayout)view.findViewById(R.id.username);
        pos=(TextInputLayout)view.findViewById(R.id.position);
        comname=(TextInputLayout)view.findViewById(R.id.companyname);
        exp=(TextInputLayout)view.findViewById(R.id.experince);
        reg=(Button) view.findViewById(R.id.register);

        reg.setOnClickListener(v -> {

            String user=uname.getEditText().getText().toString();
            String posi=pos.getEditText().getText().toString();
            String com=comname.getEditText().getText().toString();
            String expi=exp.getEditText().getText().toString();
            FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
            DatabaseReference ref=firebaseDatabase.getReference("Company");
           model mod=new model(user,posi,com,expi);
           ref.child(com).child(user).setValue(mod);
           uname.getEditText().setText("");
           pos.getEditText().setText("");
           comname.getEditText().setText("");
           exp.getEditText().setText("");
            Toast.makeText(getContext(),"successful register",Toast.LENGTH_LONG).show();




        });


        addcollege=(Button)view.findViewById(R.id.addcollege);
        scrollView=(ScrollView)view.findViewById(R.id.scrollView2) ;
        addcollege.setOnClickListener(v -> {
            frag.replace(R.id.framelayout,new AddCollegeFragment());
            frag.commit();

        });





        return view;

    }



}