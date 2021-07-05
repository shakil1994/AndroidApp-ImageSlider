package com.blackbirds.shakil.imagesliding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.blackbirds.shakil.imagesliding.Adapter.SliderAdapter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class SplashScreenActivity extends AppCompatActivity {

    Button btnNext;
    SliderView imageSlider;

    int[] imagesArray = {R.drawable.images1,
            R.drawable.images2,
            R.drawable.images3,
            R.drawable.images4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        imageSlider = findViewById(R.id.imageSlider);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(v -> {
            startActivity(new Intent(this, HomeActivity.class));
        });

        SliderAdapter sliderAdapter = new SliderAdapter(this, imagesArray);

        imageSlider.setSliderAdapter(sliderAdapter);
        imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM);
        imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        imageSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        imageSlider.setScrollTimeInSec(4);
        imageSlider.startAutoCycle();
    }
}