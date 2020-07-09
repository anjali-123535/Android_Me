package com.example.android_me.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import com.example.android_me.R;
import com.example.android_me.data.AndroidImageAssets;

import java.util.List;

public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);
        //only create new fragments if there are no previously saved instance
        if(savedInstanceState==null)
        {
            Log.d("AndoidMe Activity","savedintansse is null");
        //createa a new bodypartfragment instance and display it using fragment mansager
        BodyPartFragment headFragment=new BodyPartFragment();
        //use fragment manager and transaction to add the fragmetn to the screen
        headFragment.setmImageIds(AndroidImageAssets.getHeads());

            // Get the correct index to access in the array of head images from the intent
            // Set the default value to 0
            int headIndex = getIntent().getIntExtra("headIndex", 0);
            headFragment.setmListIndex(headIndex);
        FragmentManager fragmentManager=getSupportFragmentManager();
        //fragment transaction
        fragmentManager.beginTransaction().add(R.id.head_container,headFragment).commit();

        BodyPartFragment bodyFragment=new BodyPartFragment();
        //use fragment manager and transaction to add the fragmetn to the screen
        bodyFragment.setmImageIds(AndroidImageAssets.getBodies());
            int bodyIndex = getIntent().getIntExtra("bodyIndex", 0);

            bodyFragment.setmListIndex(bodyIndex);
        //fragment transaction
        fragmentManager.beginTransaction().add(R.id.body_container,bodyFragment).commit();

        BodyPartFragment legFragment=new BodyPartFragment();
        //use fragment manager and transaction to add the fragmetn to the screen
        legFragment.setmImageIds(AndroidImageAssets.getLegs());
            int legIndex = getIntent().getIntExtra("legIndex", 0);
            legFragment.setmListIndex(legIndex);
        //fragment transaction
        fragmentManager.beginTransaction().add(R.id.leg_container,legFragment).commit();
    }
    }
}
