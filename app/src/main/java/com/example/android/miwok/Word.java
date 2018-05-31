package com.example.android.miwok;

/**
 * Created by wuhyn on 24/03/2018.
 */

public class Word {

    /*Default translation of word*/
    private String mDefaultTranslation;

    /*Miwok Translation of word*/
    private String mMiwokTranslation;

    /*Image resource id of the word*/
    private int mImageResourceId;

    public Word(String defaultTranslation, String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
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
}
