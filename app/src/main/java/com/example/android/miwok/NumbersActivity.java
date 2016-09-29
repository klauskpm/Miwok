package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("lutti", getString(R.string.translation_number_one), R.raw.number_one, R.drawable.number_one));
        words.add(new Word("otiiko", getString(R.string.translation_number_two), R.raw.number_two, R.drawable.number_two));
        words.add(new Word("tolookosu", getString(R.string.translation_number_three), R.raw.number_three, R.drawable.number_three));
        words.add(new Word("oyyisa", getString(R.string.translation_number_four), R.raw.number_four, R.drawable.number_four));
        words.add(new Word("massokka", getString(R.string.translation_number_five), R.raw.number_five, R.drawable.number_five));
        words.add(new Word("temmokka", getString(R.string.translation_number_six), R.raw.number_six, R.drawable.number_six));
        words.add(new Word("kenekaku", getString(R.string.translation_number_seven), R.raw.number_seven, R.drawable.number_seven));
        words.add(new Word("kiwinta", getString(R.string.translation_number_eight), R.raw.number_eight, R.drawable.number_eight));
        words.add(new Word("wo'e", getString(R.string.translation_number_nine), R.raw.number_nine, R.drawable.number_nine));
        words.add(new Word("na'aacha", getString(R.string.translation_number_ten), R.raw.number_ten, R.drawable.number_ten));

        WordAdapter itemsAdapter =
                new WordAdapter(this, R.layout.list_item, words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);
        assert listView != null;
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                Word currentWord = words.get(i);
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, currentWord.getAudioResourceId());
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();

            mMediaPlayer = null;
        }
    }
}
