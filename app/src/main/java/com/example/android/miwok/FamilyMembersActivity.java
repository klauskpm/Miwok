package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("әpә", getString(R.string.translation_family_father), R.raw.family_father, R.drawable.family_father));
        words.add(new Word("әṭa", getString(R.string.translation_family_mother), R.raw.family_mother, R.drawable.family_mother));
        words.add(new Word("angsi", getString(R.string.translation_family_son), R.raw.family_son, R.drawable.family_son));
        words.add(new Word("tune", getString(R.string.translation_family_daughter), R.raw.family_daughter, R.drawable.family_daughter));
        words.add(new Word("taachi", getString(R.string.translation_family_older_brother), R.raw.family_older_brother,
                R.drawable.family_older_brother));
        words.add(new Word("chalitti", getString(R.string.translation_family_younger_brother), R.raw.family_younger_brother,
                R.drawable.family_younger_brother));
        words.add(new Word("teṭe", getString(R.string.translation_family_older_sister), R.raw.family_older_sister,
                R.drawable.family_older_sister));
        words.add(new Word("kolliti", getString(R.string.translation_family_younger_sister), R.raw.family_younger_sister,
                R.drawable.family_younger_sister));
        words.add(new Word("ama", getString(R.string.translation_family_grandmother), R.raw.family_grandmother,
                R.drawable.family_grandmother));
        words.add(new Word("paapa", getString(R.string.translation_family_grandfather), R.raw.family_grandfather,
                R.drawable.family_grandfather));

        WordAdapter itemsAdapter =
                new WordAdapter(this, R.layout.list_item, words, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);
        assert listView != null;
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word currentWord = words.get(i);
                mMediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, currentWord.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}
