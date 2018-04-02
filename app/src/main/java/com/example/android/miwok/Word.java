package com.example.android.miwok;

/**
 * Created by wuhyn on 24/03/2018.
 */

public class Word {

    /*Default translation of word*/
    private String mDefaultTranslation;

    /*Miwok Translation of word*/
    private String mMiwokTranslation;

    public Word(String defaultTranslation, String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    /*Get default translation*/
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    /*Get Miwok Translation*/
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
}
