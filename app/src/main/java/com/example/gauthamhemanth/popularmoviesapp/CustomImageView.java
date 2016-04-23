package com.example.gauthamhemanth.popularmoviesapp;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by GauthamHemanth on 4/18/16.
 */
public class CustomImageView extends ImageView {
    private int mImageWidth;
    private int mImageHeight;

    public CustomImageView(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int imageWidth = MeasureSpec.getSize(widthMeasureSpec);
        int imageHeight = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(
                Math.min(imageWidth, mImageWidth),
                Math.min(imageHeight, mImageHeight));
    }
}
