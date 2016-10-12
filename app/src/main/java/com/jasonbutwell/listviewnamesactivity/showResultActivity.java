package com.jasonbutwell.listviewnamesactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class showResultActivity extends AppCompatActivity {

    private TextView nameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);

        // Pick up the intent we passed over
        Intent intent = getIntent();

        // Attempt to extract the name from the intent
        String name = intent.getStringExtra("name");

        // Check we have received an actual value and not a null
        if ( name != null ) {

            // obtain the resource id of the view that we with to change
            nameTextView = (TextView) findViewById(R.id.nameTextView);

            // set the text of that view to show the name that was selected from the previous activity.
            nameTextView.setText("Hello " + name);
        }
    }
}
