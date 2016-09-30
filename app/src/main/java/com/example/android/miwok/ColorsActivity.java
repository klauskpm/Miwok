package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        words.add(new Word("weṭeṭṭi", getString(R.string.translation_color_red), R.raw.color_red, R.drawable.color_red));
        words.add(new Word("chokokki", getString(R.string.translation_color_green), R.raw.color_green, R.drawable.color_green));
        words.add(new Word("ṭakaakki", getString(R.string.translation_color_brown), R.raw.color_brown, R.drawable.color_brown));
        words.add(new Word("ṭopoppi", getString(R.string.translation_color_gray), R.raw.color_gray, R.drawable.color_gray));
        words.add(new Word("kululli", getString(R.string.translation_color_black), R.raw.color_black, R.drawable.color_black));
        words.add(new Word("kelelli", getString(R.string.translation_color_white), R.raw.color_white, R.drawable.color_white));
        words.add(new Word("ṭopiisә", getString(R.string.translation_color_dusty_yellow), R.raw.color_dusty_yellow,
                R.drawable.color_dusty_yellow));
        words.add(new Word("chiwiiṭә", getString(R.string.translation_color_mustard_yellow), R.raw.color_mustard_yellow,
                R.drawable.color_mustard_yellow));

        WordAdapter itemsAdapter =
                new WordAdapter(this, R.layout.list_item, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);
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
                    mMediaPlayer = MediaPlayer.create(ColorsActivity.this, currentWord.getAudioResourceId());
                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
    }

    @Override
    protected void onStop() {
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
