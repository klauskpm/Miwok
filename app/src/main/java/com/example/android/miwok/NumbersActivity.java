package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("lutti", getString(R.string.translation_number_one), R.drawable.number_one));
        words.add(new Word("otiiko", getString(R.string.translation_number_two), R.drawable.number_two));
        words.add(new Word("tolookosu", getString(R.string.translation_number_three), R.drawable.number_three));
        words.add(new Word("oyyisa", getString(R.string.translation_number_four), R.drawable.number_four));
        words.add(new Word("massokka", getString(R.string.translation_number_five), R.drawable.number_five));
        words.add(new Word("temmokka", getString(R.string.translation_number_six), R.drawable.number_six));
        words.add(new Word("kenekaku", getString(R.string.translation_number_seven), R.drawable.number_seven));
        words.add(new Word("kiwinta", getString(R.string.translation_number_eight), R.drawable.number_eight));
        words.add(new Word("wo'e", getString(R.string.translation_number_nine), R.drawable.number_nine));
        words.add(new Word("na'aacha", getString(R.string.translation_number_ten), R.drawable.number_ten));

        WordAdapter itemsAdapter =
                new WordAdapter(this, R.layout.list_item, words);

        ListView listView = (ListView) findViewById(R.id.list);
        assert listView != null;
        listView.setAdapter(itemsAdapter);
    }
}
