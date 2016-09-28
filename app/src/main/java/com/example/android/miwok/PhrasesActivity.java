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

        words.add(new Word("minto wuksus", getString(R.string.translation_phrase_where_going), R.raw.phrase_where_are_you_going));
        words.add(new Word("tinnә oyaase'nә", getString(R.string.translation_phrase_what_name), R.raw.phrase_what_is_your_name));
        words.add(new Word("oyaaset...", getString(R.string.translation_phrase_my_name), R.raw.phrase_my_name_is));
        words.add(new Word("michәksәs?", getString(R.string.translation_phrase_how_feeling), R.raw.phrase_how_are_you_feeling));
        words.add(new Word("kuchi achit", getString(R.string.translation_phrase_feeling_good), R.raw.phrase_im_feeling_good));
        words.add(new Word("әәnәs'aa?", getString(R.string.translation_phrase_you_comming), R.raw.phrase_are_you_coming));
        words.add(new Word("hәә’ әәnәm", getString(R.string.translation_phrase_yes_comming), R.raw.phrase_yes_im_coming));
        words.add(new Word("әәnәm", getString(R.string.translation_phrase_comming), R.raw.phrase_im_coming));
        words.add(new Word("yoowutis", getString(R.string.translation_phrase_lets_go), R.raw.phrase_lets_go));
        words.add(new Word("әnni'nem", getString(R.string.translation_phrase_come_here), R.raw.phrase_come_here));

        WordAdapter itemsAdapter =
                new WordAdapter(this, R.layout.list_item, words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);
        assert listView != null;
        listView.setAdapter(itemsAdapter);
    }
}
