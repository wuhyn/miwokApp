package com.example.android.miwok;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    //Handles audio playback
    private MediaPlayer mMediaPlayer;

    //This listener gets triggered when MediaPlayer has completed playing the audio file.
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create arraylist called words
        final ArrayList<Word> words = new ArrayList<>();

        //Add words to arraylist
        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));

        //Put the the words arraylist into WordAdapter
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

        //Find the listView in word_list.xml
        ListView listView = (ListView)findViewById(R.id.list);

        //Insert list items using an adapter
        listView.setAdapter(adapter);

        //On Item click listener for each number audio file
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(NumbersActivity.this, "List item clicked", Toast.LENGTH_SHORT).show();

                //Get the word object based on the one the user clicked on
                Word word = words.get(position);

                //Release mediaplayer resources here in case an audio is played before previous one
                //ends
                releaseMediaPlayer();

                //Create the audio resource associated with the word
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());

                //Start the audio file
                mMediaPlayer.start();

                //When sound stops playing, release the memory
                mMediaPlayer.setOnCompletionListener(mCompletionListener);

            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();

        //Release media player resources because when activity stops, sounds don't need to be played.
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){
        if(mMediaPlayer != null){

            mMediaPlayer.release();

            mMediaPlayer = null;
        }
    }
}
