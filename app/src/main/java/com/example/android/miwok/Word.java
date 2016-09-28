package com.example.android.miwok;

/**
 * Created by Kazlauskas on 25/09/2016.
 */
public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mAudioResourceId;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Instantiates a new Word.
     *
     * @param mMiwokTranslation   the miwok translation
     * @param mDefaultTranslation the default translation
     * @param mAudioResourceId    the audio resource id
     */
    public Word(String mMiwokTranslation, String mDefaultTranslation, int mAudioResourceId) {
        this.mMiwokTranslation = mMiwokTranslation;
        this.mDefaultTranslation = mDefaultTranslation;
        this.mAudioResourceId = mAudioResourceId;
    }

    /**
     * Instantiates a new Word.
     *
     * @param mMiwokTranslation   the miwok translation
     * @param mDefaultTranslation the default translation
     * @param mAudioResourceId    the audio resource id
     * @param mImageResourceId    the image resource id
     */
    public Word(String mMiwokTranslation, String mDefaultTranslation, int mAudioResourceId, int mImageResourceId) {
        this.mMiwokTranslation = mMiwokTranslation;
        this.mDefaultTranslation = mDefaultTranslation;
        this.mAudioResourceId = mAudioResourceId;
        this.mImageResourceId = mImageResourceId;
    }

    /**
     * Gets miwok translation.
     *
     * @return the miwok translation
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Gets default translation.
     *
     * @return the default translation
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Gets image resource id.
     *
     * @return the image resource id
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Has image boolean.
     *
     * @return the boolean
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Gets audio resource id.
     *
     * @return the audio resource id
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}
