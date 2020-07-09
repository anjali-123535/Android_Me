package com.example.android_me.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android_me.R;
import com.example.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {
    // Final Strings to store state information about the list of images and list index
    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";
    private static final String TAG =BodyPartFragment.class.getName();
    //variables to store the list of image resources and the index of the image that this fragment displays
    private List<Integer> mImageIds;
    private int mListIndex;
    public BodyPartFragment(){

    }
    /**

     * Inflates the fragment layout file and sets the correct resource for the image to display

     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Load the saved state (the list of images and list index) if there is one
        if(savedInstanceState != null) {
            Log.d(TAG,"saved is not null");
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }
        // Inflate the Android-Me fragment layout
        View rootView=inflater.inflate(R.layout.fragment_body_part,container,false);
        // Get a reference to the ImageView in the fragment layout
        final ImageView body_part=(ImageView)rootView.findViewById(R.id.body_part_iv);
        // If a list of image ids exists, set the image resource to the correct item in that list
        // Otherwise, create a Log statement that indicates that the list was not found
        if(body_part!=null) {
            body_part.setImageResource(mImageIds.get(mListIndex));
            body_part.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListIndex <mImageIds.size() - 1)
                        mListIndex++;
                    else
                        mListIndex=0;
                    body_part.setImageResource(mImageIds.get(mListIndex));
                }
            });
        }
        else
            Log.v(TAG,"this fragment has a null list of image ids");
        return rootView;
    }
// Setter methods for keeping track of the list images this fragment can display and which image
    // in the list is currently being displayed
    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public void setmListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }
    /**
     * Save the current state of this fragment
     */
    @Override
    public void onSaveInstanceState(Bundle currentState) {
        Log.d(TAG,"on saved instance called  "+mListIndex);
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX, mListIndex);
    }
}
