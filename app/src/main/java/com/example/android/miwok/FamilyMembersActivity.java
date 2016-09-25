package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("әpә", getString(R.string.translation_family_father)));
        words.add(new Word("әṭa", getString(R.string.translation_family_mother)));
        words.add(new Word("angsi", getString(R.string.translation_family_son)));
        words.add(new Word("tune", getString(R.string.translation_family_daughter)));
        words.add(new Word("taachi", getString(R.string.translation_family_older_brother)));
        words.add(new Word("chalitti", getString(R.string.translation_family_younger_brother)));
        words.add(new Word("teṭe", getString(R.string.translation_family_older_sister)));
        words.add(new Word("kolliti", getString(R.string.translation_family_younger_sister)));
        words.add(new Word("ama", getString(R.string.translation_family_grandmother)));
        words.add(new Word("paapa", getString(R.string.translation_family_grandfather)));

        WordAdapter itemsAdapter =
                new WordAdapter(this, R.layout.list_item, words);

        ListView listView = (ListView) findViewById(R.id.list);
        assert listView != null;
        listView.setAdapter(itemsAdapter);
    }
}
