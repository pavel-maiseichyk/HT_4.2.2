package com.example.ht_422;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Drawable> images = new ArrayList<>();
    private ItemsDataAdapter adapter;
    private Button button;
    private int count = 1;
    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        ListView listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);

        fillImages();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomItemData();
                count++;
            }
        });

        adapter = new ItemsDataAdapter(this, null);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "Item зажат");
                showItemData(position);
                return true;
            }
        });
    }

    private void fillImages() {
        images.add(ContextCompat.getDrawable(MainActivity.this, android.R.drawable.ic_dialog_alert));
        images.add(ContextCompat.getDrawable(MainActivity.this, android.R.drawable.ic_delete));
        images.add(ContextCompat.getDrawable(MainActivity.this, android.R.drawable.ic_btn_speak_now));
        images.add(ContextCompat.getDrawable(MainActivity.this, android.R.drawable.ic_dialog_email));
        images.add(ContextCompat.getDrawable(MainActivity.this, android.R.drawable.ic_lock_idle_alarm));
    }

    private void generateRandomItemData() {
        Random random = new Random();
        adapter.addItem(new ItemData(
                images.get(random.nextInt(images.size())),
                "Hello There #" + count,
                "General Kenobi", button));
    }

    private void showItemData(int position) {
        ItemData itemData = adapter.getItem(position);
        Toast.makeText(MainActivity.this, "Text: " + itemData.getText() + "\n" + "SubText: " + itemData.getSubText(),
                Toast.LENGTH_LONG).show();
    }
}