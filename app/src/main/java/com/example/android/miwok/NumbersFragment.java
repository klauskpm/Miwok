package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    switch (focusChange) {
                        case AudioManager.AUDIOFOCUS_LOSS:
                            releaseMediaPlayer();
                            break;

                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                            mMediaPlayer.pause();
                            mMediaPlayer.seekTo(0);
                            break;

                        case AudioManager.AUDIOFOCUS_GAIN:
                        case AudioManager.AUDIOFOCUS_GAIN_TRANSIENT:
                            mMediaPlayer.start();
                            break;

                        default:
                            releaseMediaPlayer();
                            break;
                    }
                }
            };

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

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
                new WordAdapter(getActivity(), R.layout.list_item, words, R.color.category_numbers);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        assert listView != null;
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word currentWord = words.get(i);

                releaseMediaPlayer();

                int audioFocusRequest = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (audioFocusRequest == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(getActivity(), currentWord.getAudioResourceId());
                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();

        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();

            mMediaPlayer = null;
        }

        mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
    }
}
