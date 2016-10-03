package com.example.android.miwok;


import android.support.v4.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class CategoryFragment extends Fragment {
    private int mFragmentTitleResourceId;

    public CategoryFragment() {
        // Required empty public constructor
    }

    protected void setFragmentTitleResourceId(int titleResourceId) {
        mFragmentTitleResourceId = titleResourceId;
    }

    public int getFragmentTitleResourceId() {
        return mFragmentTitleResourceId;
    }

}
