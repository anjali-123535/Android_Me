package com.example.android_me.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android_me.R;
import com.example.android_me.data.AndroidImageAssets;
// This fragment displays all of the AndroidMe images in one large list
// The list appears as a grid of images
public class MasterListFragment extends Fragment {
    // Define a new interface OnImageClickListener that triggers a callback in the host activity

    OnImageClickListener mCallback;
    // OnImageClickListener interface, calls a method in the host activity named onImageSelected
    public interface OnImageClickListener {

        void onImageSelected(int position);

    }
    // Override onAttach to make sure that the container activity has implemented the callbac
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the host activity has implemented the callback interface
        // If not, it throws an exception
        try {
            mCallback = (OnImageClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnImageClickListener");
        }
    }

    public MasterListFragment()
    {}
    // Inflates the GridView of all AndroidMe images
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.fragment_master_list,container,false);

        // Get a reference to the GridView in the fragment_master_list xml layout file
        GridView gridView=(GridView) rootview.findViewById(R.id.images_grid_view);

        // Create the adapter
        // This adapter takes in the context and an ArrayList of ALL the image resources to display
        MasterListAdapter mAdapter=new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
Log.d("masterlistfragment","data filled");
        // Set a click listener on the gridView and trigger the callback onImageSelected when an item is clicked
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Trigger the callback method and pass in the position that was clicked
                mCallback.onImageSelected(position);
            }
        });

        // Set the adapter on the GridView
        gridView.setAdapter(mAdapter);
        return rootview;
    }
}
