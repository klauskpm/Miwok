package com.example.android.miwok;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by klaus on 03/10/16.
 */

public class CategoryAdapter extends FragmentPagerAdapter {
    private ArrayList<CategoryFragment> mFragmentArrayList = new ArrayList<CategoryFragment>();
    private Context mContext;

    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getString(mFragmentArrayList.get(position).getFragmentTitleResourceId());
    }

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);

        mContext = context;

        mFragmentArrayList.add(new NumbersFragment());
        mFragmentArrayList.add(new FamilyMembersFragment());
        mFragmentArrayList.add(new ColorsFragment());
        mFragmentArrayList.add(new PhrasesFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentArrayList.size();
    }
}
