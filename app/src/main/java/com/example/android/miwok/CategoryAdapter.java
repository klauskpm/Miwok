package com.example.android.miwok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by klaus on 03/10/16.
 */

public class CategoryAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mFragmentArrayList = new ArrayList<Fragment>();

    public CategoryAdapter(FragmentManager fm) {
        super(fm);

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
