package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kazlauskas on 25/09/2016.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mListColor;

    public WordAdapter(Context context, int resource, ArrayList<Word> words, int listColor) {
        super(context, 0, words);

        mListColor = listColor;
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

        int color = ContextCompat.getColor(getContext(), mListColor);
        LinearLayout itemContent = (LinearLayout) listView.findViewById(R.id.list_item_content);
        itemContent.setBackgroundColor(color);

        TextView miwokTextView = (TextView) listView.findViewById(R.id.miwok_translation);
        miwokTextView.setText(word.getMiwokTranslation());

        TextView defaultTextView = (TextView) listView.findViewById(R.id.default_translation);
        defaultTextView.setText(word.getDefaultTranslation());

        ImageView itemImageView = (ImageView) listView.findViewById(R.id.list_item__image_view);
        assert itemImageView != null;

        if (word.hasImage())
            itemImageView.setImageResource(word.getImageResourceId());
        else
            itemImageView.setVisibility(View.GONE);

        return listView;
    }
}
