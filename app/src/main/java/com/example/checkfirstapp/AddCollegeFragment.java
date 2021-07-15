package com.example.checkfirstapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
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
 * Use the {@link AddCollegeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddCollegeFragment extends Fragment {
    Button addcompany,reg2;

    TextInputLayout sname,branchname,collname,exp;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddCollegeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddCollegeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddCollegeFragment newInstance(String param1, String param2) {
        AddCollegeFragment fragment = new AddCollegeFragment();
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
        View view = inflater.inflate(R.layout.fragment_add_college, container, false);
        //hooks
        sname=( TextInputLayout)view.findViewById(R.id.student);
        branchname=( TextInputLayout)view.findViewById(R.id.branch);
        collname=( TextInputLayout)view.findViewById(R.id.collegename);
        exp=( TextInputLayout)view.findViewById(R.id.experience1);
        reg2=(Button)view.findViewById(R.id.reg2);

        reg2.setOnClickListener(v -> {


            String user=sname.getEditText().getText().toString();
            String posi=branchname.getEditText().getText().toString();
            String com=collname.getEditText().getText().toString();
            String expi=exp.getEditText().getText().toString();
            FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
            DatabaseReference ref=firebaseDatabase.getReference("College");
            model mod=new model(user,posi,com,expi);
            ref.child(com).child(user).setValue(mod);
            sname.getEditText().setText("");
            branchname.getEditText().setText("");
            collname.getEditText().setText("");
            exp.getEditText().setText("");
            Toast.makeText(getContext(),"successful register",Toast.LENGTH_LONG).show();




        });













        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        addcompany = (Button) view.findViewById(R.id.addcompany);

        addcompany.setOnClickListener(v -> {
            fragmentTransaction.replace(R.id.framelayout,new AddCompanyFragment());
            fragmentTransaction.commit();

        });


        return view;
    }

}