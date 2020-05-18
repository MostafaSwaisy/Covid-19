package com.example.cov19.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.cov19.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context, LayoutInflater layoutInflater) {
        this.context = context;
        this.layoutInflater = layoutInflater;
    }
    public SliderAdapter(Context context) {
        this.context = context;
    }

    int[] slide_image = {
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground , R.drawable.ic_launcher_background
    };

    String[] slide_headings = {
            "EAT","SLEEP","CODE"
    };
    String[] slideDescs = {
            "asdsadasd","asdasdasfsd","asdasdasfxcv"
    };


    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container ,false);
        ImageView slideImageView = view.findViewById(R.id.slide_image);
        TextView slideHeading = view.findViewById(R.id.slide_heading);
        TextView slideDesc = view.findViewById(R.id.slide_desc);
        slideImageView.setImageResource(slide_image[position]);
        slideHeading.setText(slide_headings[position]);
        slideDesc.setText(slideDescs[position]);
        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
