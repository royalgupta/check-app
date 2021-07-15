package com.example.checkfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
  Toolbar tool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tool=findViewById(R.id.toolbar2);
        setSupportActionBar(tool);



        BottomNavigationView nav=(BottomNavigationView)findViewById(R.id.bottomNav);
        FragmentTransaction frag=getSupportFragmentManager().beginTransaction();
        frag.replace(R.id.framelayout,new CompanyFragment());
        frag.commit();

        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction frag=getSupportFragmentManager().beginTransaction();
                switch(item.getItemId())
                {
                    case R.id.company:
                        frag.replace(R.id.framelayout,new CompanyFragment());


                        break;
                    case R.id.add:

                        frag.replace(R.id.framelayout,new AddCompanyFragment());


                        break;
                    case R.id.college:
                        frag.replace(R.id.framelayout,new CollegeFragment());

                        break;


                }
                frag.commit();
                return true;
            }

        });
    }


}