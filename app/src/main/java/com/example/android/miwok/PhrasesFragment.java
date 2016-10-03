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
public class PhrasesFragment extends Fragment {

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

    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Word> words = new ArrayList<Word>();

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        words.add(new Word("minto wuksus", getString(R.string.translation_phrase_where_going),
                R.raw.phrase_where_are_you_going));
        words.add(new Word("tinnә oyaase'nә", getString(R.string.translation_phrase_what_name),
                R.raw.phrase_what_is_your_name));
        words.add(new Word("oyaaset...", getString(R.string.translation_phrase_my_name), R.raw.phrase_my_name_is));
        words.add(new Word("michәksәs?", getString(R.string.translation_phrase_how_feeling), R.raw.phrase_how_are_you_feeling));
        words.add(new Word("kuchi achit", getString(R.string.translation_phrase_feeling_good), R.raw.phrase_im_feeling_good));
        words.add(new Word("әәnәs'aa?", getString(R.string.translation_phrase_you_comming), R.raw.phrase_are_you_coming));
        words.add(new Word("hәә’ әәnәm", getString(R.string.translation_phrase_yes_comming), R.raw.phrase_yes_im_coming));
        words.add(new Word("әәnәm", getString(R.string.translation_phrase_comming), R.raw.phrase_im_coming));
        words.add(new Word("yoowutis", getString(R.string.translation_phrase_lets_go), R.raw.phrase_lets_go));
        words.add(new Word("әnni'nem", getString(R.string.translation_phrase_come_here), R.raw.phrase_come_here));

        WordAdapter itemsAdapter =
                new WordAdapter(getActivity(), R.layout.list_item, words, R.color.category_phrases);

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
