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

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("weṭeṭṭi", getString(R.string.translation_color_red)));
        words.add(new Word("chokokki", getString(R.string.translation_color_green)));
        words.add(new Word("ṭakaakki", getString(R.string.translation_color_brown)));
        words.add(new Word("ṭopoppi", getString(R.string.translation_color_gray)));
        words.add(new Word("kululli", getString(R.string.translation_color_black)));
        words.add(new Word("kelelli", getString(R.string.translation_color_white)));
        words.add(new Word("ṭopiisә", getString(R.string.translation_color_dusty_yellow)));
        words.add(new Word("chiwiiṭә", getString(R.string.translation_color_mustard_yellow)));

        WordAdapter itemsAdapter =
                new WordAdapter(this, R.layout.list_item, words);

        ListView listView = (ListView) findViewById(R.id.list);
        assert listView != null;
        listView.setAdapter(itemsAdapter);
    }
}
