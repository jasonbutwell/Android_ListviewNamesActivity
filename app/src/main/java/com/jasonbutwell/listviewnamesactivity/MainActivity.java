package com.jasonbutwell.listviewnamesactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // A view for our list view
    private ListView mListView;

    // The method that is called when a list view element is clicked on

    private void passNameToShowResult( String name  ) {
        // build a new Intent
        Intent intent = new Intent(getApplicationContext(), showResultActivity.class);

        // Put the name variable into the intent
        intent.putExtra( "name", name );

        // start the second activity
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // obtain resource id of list view
        mListView = (ListView) findViewById(R.id.nameListView);

        // An arraylist to hold our names
        final ArrayList<String> names = new ArrayList<>();

        // Add in 4 names as instructed.
        names.add("Jason");
        names.add("Raymond");
        names.add("Christopher");
        names.add("Wayne");

        // create a new array adapter for the list
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, names);

        // set the adapter to use for this view
        mListView.setAdapter(adapter);

        // set up the code to respond to what we have clicked
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // We fill out the method provided by the setOnItemClickListener interface
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtain the value of the item we clicked on via it's index
                String value = (String) adapter.getItem(position);

                // Send this to the log so we can see it
                //Log.i("value", value);

                // pass this on so we can send it to another activity
                passNameToShowResult( value );
            }
        }
        );
    }
}
