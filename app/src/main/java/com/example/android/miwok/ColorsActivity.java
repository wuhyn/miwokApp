package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create arraylist called words
        ArrayList<Word> words = new ArrayList<Word>();

        //Add words to arraylist
        words.add(new Word("red", "weṭeṭṭi"));
        words.add(new Word("green", "chokokki"));
        words.add(new Word("brown", "takakki"));
        words.add(new Word("gray", "ṭopoppi"));
        words.add(new Word("black", "kululli"));
        words.add(new Word("white", "kelelli"));
        words.add(new Word("dusty yellow","ṭopiisә"));
        words.add(new Word("mustard yellow", "chiwiiṭә"));

        //Put the the words arraylist into WordAdapter
        WordAdapter adapter = new WordAdapter(this, words);

        //Find the listView
        ListView listView = (ListView)findViewById(R.id.list);

        //Insert list items using an adapter
        listView.setAdapter(adapter);



    }
}
