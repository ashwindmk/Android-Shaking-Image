package com.example.ashwin.shakingimage;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;
    private Button mShakeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        mImageView = (ImageView) findViewById(R.id.imageView);

        mShakeButton = (Button) findViewById(R.id.shakeButton);
        mShakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shakeImage();
            }
        });
    }

    private void shakeImage() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(
                ObjectAnimator.ofFloat(mImageView, "translationY", 0, 20, -20, 15, -15, 6, -6, 0).setDuration(1500),
                ObjectAnimator.ofFloat(mImageView, "translationX", 0, 20, -20, 15, -15, 6, -6, 0).setDuration(1500));
        animatorSet.start();
    }
}
