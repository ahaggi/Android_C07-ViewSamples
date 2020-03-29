package com.introtoandroid.viewsamples;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewAnimator;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ImagesContainersIIIActivity extends AppCompatActivity {
    ViewAnimator viewAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.containers3);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button switch_button = (Button) findViewById(R.id.switch_button3);

        viewAnimator = (ViewAnimator) findViewById(R.id.viewAnimator);
        addImageViewsToAnimator();
        viewAnimator.setInAnimation(this, android.R.anim.slide_out_right);


        switch_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(ImagesContainersIIIActivity.this, "Switching", Toast.LENGTH_SHORT).show();
                viewAnimator.showNext();
            }
        });
    }


    public void addImageViewsToAnimator(){
        ArrayList<Integer> bilderIds = iteratorDrawable();
        for (int id:bilderIds) {
            ImageView imVw = new ImageView(this);
            imVw.setImageResource(id);
            viewAnimator.addView(imVw);
        }

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
