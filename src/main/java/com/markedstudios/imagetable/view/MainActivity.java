package com.markedstudios.imagetable.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;

import com.markedstudios.imagetable.controller.AHerosTask;
import com.markedstudios.imagetable.controller.HerosAdapter;
import com.markedstudios.imagetable.R;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    public static String url="https://simplifiedcoding.net/demos/marvel/";
    public RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AHerosTask aHerosTask = new AHerosTask();

        try {
            HerosAdapter adapter = new HerosAdapter(aHerosTask.execute(url).get());
            recyclerView = findViewById(R.id.heros_recycler);
            recyclerView.setLayoutManager(new GridLayoutManager(getBaseContext(),3));
            recyclerView.setAdapter(adapter);

        } catch (InterruptedException ie){

        } catch(ExecutionException ee){

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
