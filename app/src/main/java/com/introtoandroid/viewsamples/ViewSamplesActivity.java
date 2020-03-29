package com.introtoandroid.viewsamples;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.HashMap;
import java.util.Map;

public class ViewSamplesActivity extends AppCompatActivity {

    protected Map<String, Object> actions = new HashMap<>();

    public final static String debugTag = "ViewSamples";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        prepareMenu();

        String[] keys = actions.keySet().toArray(new String[actions.keySet().size()]);

        ListView av = (ListView) findViewById(R.id.menu_list);
        ListAdapter adapter = new ArrayAdapter<>(
                    this, android.R.layout.simple_list_item_1, keys);

        av.setAdapter(adapter);
        av.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent,
                                            View view, int position, long id) {
                        /** OBS (String) her **/
                        String key = (String) parent.getItemAtPosition(position);
                        startActivity((Intent) actions.get(key));
                    }
        });
    }

    void prepareMenu() {
        actions.put("Forms", new Intent(this, FormsActivity.class) );
        actions.put("Indicators", new Intent(this, IndicatorsActivity.class) );
        actions.put("ImagesContainersI", new Intent(this, ImagesContainersActivity.class) );
        actions.put("ImagesContainersII", new Intent(this, ImagesContainersIIActivity.class) );
        actions.put("ImagesContainersIII", new Intent(this, ImagesContainersIIIActivity.class) );
        actions.put("Text Display", new Intent(this, TextDisplayActivity.class) );
        actions.put("Events", new Intent(this, EventsActivity.class) );
        actions.put("Video", new Intent(this, VideoViewActivity.class) );
    }


}