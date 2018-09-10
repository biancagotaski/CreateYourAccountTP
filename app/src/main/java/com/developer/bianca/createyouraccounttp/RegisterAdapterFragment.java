package com.developer.bianca.createyouraccounttp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class RegisterAdapterFragment extends FragmentPagerAdapter {

    private final int FRAGMENTS_COUNT = 2;

    public RegisterAdapterFragment(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
//        switch (position){
//            case 0:
//                return RegisterListFragment.newInstance(Constants.ACTIVE_)
//        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return 0;
    }
}
