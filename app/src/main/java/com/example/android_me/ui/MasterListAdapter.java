package com.example.android_me.ui;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

// Custom adapter class that displays a list of Android-Me images in a GridView
public class MasterListAdapter extends BaseAdapter {
    // Keeps track of the context and list of images to display
    private List<Integer>mImageIds;
    private Context mContext;
    /**
     * Constructor method
     * @param imageIds The list of images to display
     */
    public MasterListAdapter(Context context, List<Integer> imageIds)
    {
        mContext=context;
        mImageIds = imageIds;

    }
    /**
     * Returns the number of items the adapter will disply
     */
    @Override
    public int getCount() {
        return mImageIds.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    /**
     * Creates a new ImageView for each item referenced by the adapter
     */
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ImageView imageView;
        if (convertView == null) {
            Log.d("masterlistadapter","convert view is null");
            // If the view is not recycled, this creates a new ImageView to hold an image
            imageView = new ImageView(mContext);
            // Define the layout parameters
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            Log.d("masterlistadapter","convert view is not null");
            imageView = (ImageView) convertView;
        }
        // Set the image resource and return the newly created ImageView
        imageView.setImageResource(mImageIds.get(position));
        return imageView;
    }
    }
