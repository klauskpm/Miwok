package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("minto wuksus", getString(R.string.translation_phrase_where_going)));
        words.add(new Word("tinnә oyaase'nә", getString(R.string.translation_phrase_what_name)));
        words.add(new Word("oyaaset...", getString(R.string.translation_phrase_my_name)));
        words.add(new Word("michәksәs?", getString(R.string.translation_phrase_how_feeling)));
        words.add(new Word("kuchi achit", getString(R.string.translation_phrase_feeling_good)));
        words.add(new Word("әәnәs'aa?", getString(R.string.translation_phrase_you_comming)));
        words.add(new Word("hәә’ әәnәm", getString(R.string.translation_phrase_yes_comming)));
        words.add(new Word("әәnәm", getString(R.string.translation_phrase_comming)));
        words.add(new Word("yoowutis", getString(R.string.translation_phrase_lets_go)));
        words.add(new Word("әnni'nem", getString(R.string.translation_phrase_come_here)));

        WordAdapter itemsAdapter =
                new WordAdapter(this, R.layout.list_item, words);

        ListView listView = (ListView) findViewById(R.id.list);
        assert listView != null;
        listView.setAdapter(itemsAdapter);
    }
}
