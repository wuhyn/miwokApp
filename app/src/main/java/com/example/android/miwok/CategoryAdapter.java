package com.example.android.miwok;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context context;

    public CategoryAdapter(FragmentManager fm, Context mContext) {
        super(fm);
        context = mContext;
    }

    @Override
    public CharSequence getPageTitle(int position) {
      //return super.getPageTitle(position);
        if(position == 0){
            return context.getResources().getString(R.string.category_numbers);
        }
        else if(position == 1){
            return context.getResources().getString(R.string.category_family);
        }
        else if(position == 2){
            return context.getResources().getString(R.string.category_colors);
        }
        else{
            return context.getResources().getString(R.string.category_phrases);
        }

    }

    @Override
    public Fragment getItem(int position){
        if(position == 0){
            return new NumbersFragment();
        }
        else if(position == 1){
            return new FamilyFragment();
        }
        else if(position == 2){
            return new ColorsFragment();
        }
        else{
            return new PhrasesFragment();
        }
    }

    @Override
    public int getCount(){
        return 4;
    }
}
