package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kazlauskas on 25/09/2016.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    public WordAdapter(Context context, int resource, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false
            );
        }

        Word word = getItem(position);
        assert word != null;

        TextView miwokTextView = (TextView) listView.findViewById(R.id.miwok_translation);
        miwokTextView.setText(word.getMiwokTranslation());

        TextView defaultTextView = (TextView) listView.findViewById(R.id.default_translation);
        defaultTextView.setText(word.getDefaultTranslation());

        return listView;
    }
}
