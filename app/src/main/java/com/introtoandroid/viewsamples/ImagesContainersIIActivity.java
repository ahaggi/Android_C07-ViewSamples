package com.introtoandroid.viewsamples;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ImagesContainersIIActivity extends AppCompatActivity {
    ImageSwitcher switcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.containers2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        switcher = (ImageSwitcher) findViewById(R.id.img_switch2);
        switcher.setFactory(()->{

            ImageView myView = new ImageView(getApplicationContext());
            myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            myView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            return myView;

        });
        addImageViewsToAnimator();

        Button switch_button = (Button) findViewById(R.id.switch_button2);
        switch_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(ImagesContainersIIActivity.this, "Switching", Toast.LENGTH_SHORT).show();
                switcher.showNext();
            }
        });




    }

    public void addImageViewsToAnimator(){
        ArrayList<Integer> bilderIds = iteratorDrawable();
        for (int id:bilderIds)
            switcher.setImageResource(id);
     }

    public ArrayList<Integer> iteratorDrawable(){
        ArrayList<Integer> bilderIds = new ArrayList<>();

        for (Field felt : R.drawable.class.getFields())
            try {
                if(felt.getName().matches("^droid+\\S*$")){
                    bilderIds.add(felt.getInt(null));
                    //Log.i("LOG_TAG", "------------***********-----------" + field.getName() + " ##### " + field.getInt(null))
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return bilderIds;

    }

}
