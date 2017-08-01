package com.raghibm.rgb.radomizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView left = (ImageView) findViewById(R.id.imageView1);
        final ImageView right = (ImageView) findViewById(R.id.imageView2);
        final Button clickMe = (Button) findViewById(R.id.button);

        final Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setStartOffset(1000);
        fadeOut.setDuration(1000);
        left.setAnimation(fadeOut);
        right.setAnimation(fadeOut);

        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {


            }

            @Override
            public void onAnimationEnd(Animation animation) {
                left.setVisibility(View.GONE);
                right.setVisibility(View.GONE);
                clickMe.setVisibility(View.VISIBLE);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        clickMe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Random r = new Random();
                int i = r.nextInt(2);
                clickMe.setVisibility(View.GONE);
                if(i == 0){
                    left.setVisibility(View.VISIBLE);
                    left.startAnimation(fadeOut);
                }else{
                    right.setVisibility(View.VISIBLE);
                    right.startAnimation(fadeOut);
                }

            }
        });

    }
}
