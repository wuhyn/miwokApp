package com.example.android.miwok;

/**
 * Created by wuhyn on 24/03/2018.
 */

public class Word {

    /*Default translation of word*/
    private String mDefaultTranslation;

    /*Miwok Translation of word*/
    private String mMiwokTranslation;

    /*Audio resource id*/
    private int mAudioResourceId;

    /*Image resource id of the word*/
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /*Get default translation*/
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    /*Get Miwok Translation*/
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    /*Get image resource id*/
    public int getImageResourceId(){
        return mImageResourceId;
    }

    /*Return if there is an image or not*/
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /*Get audio resource id*/
    public int getAudioResourceId(){
        return mAudioResourceId;
    }
}
