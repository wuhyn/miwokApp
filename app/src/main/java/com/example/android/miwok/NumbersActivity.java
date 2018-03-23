package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        //Create arraylist called words
        ArrayList<String> words = new ArrayList<>();

        //Add words to arraylist
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        words.add("nine");
        words.add("ten");

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);

        ListView listView = (ListView)findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

//        //Point to the rootView in numbersActivity.xml
//        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);
//
//        //Setting up while loop
//        int index;
//
//        for(index = 0; index < words.size(); index++){
//            TextView wordView = new TextView(this);
//
//            //Set text as it iterates thru the arraylist
//            wordView.setText(words.get(index));
//
//            //Add view
//            rootView.addView(wordView);
//        }

        


    }
}
