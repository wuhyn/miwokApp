package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

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
        final ArrayList<Word> words = new ArrayList<Word>();

        //Add words to arraylist
        words.add(new Word("father", "әpә", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("son", "angsi", R.drawable.family_son, R.raw.family_son));
        words.add(new Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("older sister","teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("younger sister","kolliti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        //Put the the words arraylist into WordAdapter
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);

        //Find the listView
        ListView listView = (ListView)findViewById(R.id.list);

        //Insert list items using an adapter
        listView.setAdapter(adapter);

        //On Item click listener for each family audio file
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Get the word object based on the one the user clicked on
                Word word = words.get(position);

                //Release mediaplayer resources here in case an audio is played before previous one
                //ends
                releaseMediaPlayer();

                //Create the audio resource associated with the word
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());

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
