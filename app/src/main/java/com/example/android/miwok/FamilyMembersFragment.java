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
public class FamilyMembersFragment extends CategoryFragment {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    switch(focusChange) {
                        case AudioManager.AUDIOFOCUS_LOSS:
                            releaseMediaPlayer();
                            break;

                        case AudioManager.AUDIOFOCUS_GAIN:
                        case AudioManager.AUDIOFOCUS_GAIN_TRANSIENT:
                            mMediaPlayer.start();
                            break;

                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                            mMediaPlayer.pause();
                            mMediaPlayer.seekTo(0);
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

    public FamilyMembersFragment() {
        // Required empty public constructor
        setFragmentTitleResourceId(R.string.category_family);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Word> words = new ArrayList<Word>();

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

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
                new WordAdapter(getActivity(), R.layout.list_item, words, R.color.category_family);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        assert listView != null;
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                Word currentWord = words.get(i);

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
