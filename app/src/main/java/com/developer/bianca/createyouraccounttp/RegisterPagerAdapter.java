package com.developer.bianca.createyouraccounttp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.developer.bianca.createyouraccounttp.utils.Constants;

public class RegisterPagerAdapter extends FragmentPagerAdapter {

    private final int FRAGMENTS_COUNT = 2;

    public RegisterPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return RegisterListFragment.newInstance(Constants.ACTIVE_REGISTERS_ENDPOINT);
            case 1:
                return RemoveRegisterFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return FRAGMENTS_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Cadastros";
            case 1:
                return "Apagar cadastros";
            default:
                return "";
        }
    }
}
