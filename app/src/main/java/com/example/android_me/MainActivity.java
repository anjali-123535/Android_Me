package com.example.android_me;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android_me.ui.AndroidMeActivity;
import com.example.android_me.ui.MasterListFragment;
// This activity is responsible for displaying the master list of all images
// Implement the MasterListFragment callback, OnImageClickListener
public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {
    // Variables to store the values for the list index of the selected images
    // The default value will be index = 0
    private int headIndex;
    private int bodyIndex;
    private int legIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Define the behavior for onImageSelected
    @Override
    public void onImageSelected(int position) {

        // Create a Toast that displays the position that was clicked
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();

        // Based on where a user has clicked, store the selected list index for the head, body, and leg BodyPartFragments
    // bodyPartNumber will be = 0 for the head fragment, 1 for the body, and 2 for the leg fragment
    // Dividing by 12 gives us these integer values because each list of images resources has a size of 12
    int bodyPartNumber = position /12;

    // Store the correct list index no matter where in the image list has been clicked
    // This ensures that the index will always be a value between 0-11
    int listIndex = position - 12*bodyPartNumber;

    // Set the currently displayed item for the correct body part fragment
        switch(bodyPartNumber) {
        case 0: headIndex = listIndex;
            break;
        case 1: bodyIndex = listIndex;
            break;
        case 2: legIndex = listIndex;
            break;
        default: break;
    }

        // Put this information in a Bundle and attach it to an Intent that will launch an AndroidMeActivity
        Bundle b = new Bundle();
        b.putInt("headIndex", headIndex);
        b.putInt("bodyIndex", bodyIndex);
        b.putInt("legIndex", legIndex);
        // Attach the Bundle to an intent
        final Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(b);

        // The "Next" button launches a new AndroidMeActivity
        Button nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }}
