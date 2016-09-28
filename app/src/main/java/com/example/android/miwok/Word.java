package com.example.android.miwok;

/**
 * Created by Kazlauskas on 25/09/2016.
 */
public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Instantiates a new Word.
     *
     * @param miwokTranslation   the miwok translation
     * @param defaultTranslation the default translation
     */
    public Word(String miwokTranslation, String defaultTranslation) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
    }

    /**
     * Instantiates a new Word.
     *
     * @param mMiwokTranslation   the m miwok translation
     * @param mDefaultTranslation the m default translation
     * @param mImageResourceId    the m image resource id
     */
    public Word(String mMiwokTranslation, String mDefaultTranslation, int mImageResourceId) {
        this.mMiwokTranslation = mMiwokTranslation;
        this.mDefaultTranslation = mDefaultTranslation;
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

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
