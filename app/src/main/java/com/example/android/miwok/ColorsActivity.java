package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("weṭeṭṭi", getString(R.string.translation_color_red), R.drawable.color_red));
        words.add(new Word("chokokki", getString(R.string.translation_color_green), R.drawable.color_green));
        words.add(new Word("ṭakaakki", getString(R.string.translation_color_brown), R.drawable.color_brown));
        words.add(new Word("ṭopoppi", getString(R.string.translation_color_gray), R.drawable.color_gray));
        words.add(new Word("kululli", getString(R.string.translation_color_black), R.drawable.color_black));
        words.add(new Word("kelelli", getString(R.string.translation_color_white), R.drawable.color_white));
        words.add(new Word("ṭopiisә", getString(R.string.translation_color_dusty_yellow), R.drawable.color_dusty_yellow));
        words.add(new Word("chiwiiṭә", getString(R.string.translation_color_mustard_yellow), R.drawable.color_mustard_yellow));

        WordAdapter itemsAdapter =
                new WordAdapter(this, R.layout.list_item, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);
        assert listView != null;
        listView.setAdapter(itemsAdapter);
    }
}
