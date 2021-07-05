package com.blackbirds.shakil.imagesliding.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.blackbirds.shakil.imagesliding.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.MyViewHolder> {

    Context context;
    int[] imagesArray;

    public SliderAdapter(Context context, int[] imagesArray) {
        this.context = context;
        this.imagesArray = imagesArray;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.slider_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        viewHolder.imgView.setImageResource(imagesArray[position]);
    }

    @Override
    public int getCount() {
        return imagesArray.length;
    }

    public class MyViewHolder extends ViewHolder {

        ImageView imgView;

        public MyViewHolder(View itemView) {
            super(itemView);

            imgView = itemView.findViewById(R.id.imgView);
        }
    }
}
