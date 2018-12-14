package com.example.lenovo.kitchengrossery;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class SliderAdapter extends PagerAdapter {
    private Context context;
    private List<Integer> imageites;

    public SliderAdapter(Context context, List<Integer> imageites){
        this.context=context;
        this.imageites=imageites;

    }

    @Override
    public int getCount() {
        return imageites.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.item_slider,null);
        ImageView myimage=(ImageView)view.findViewById(R.id.myimageview);
        myimage.setImageResource(imageites.get(position));
        ViewPager viewPager=(ViewPager)container;
        viewPager.addView(view,0);
        return view;
    }
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
