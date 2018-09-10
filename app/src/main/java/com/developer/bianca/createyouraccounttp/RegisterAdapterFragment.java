package com.developer.bianca.createyouraccounttp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.developer.bianca.createyouraccounttp.models.RegisterCard;
import com.developer.bianca.createyouraccounttp.utils.Constants;

public class RegisterAdapterFragment extends FragmentPagerAdapter {

    private final int FRAGMENTS_COUNT = 2;

    public RegisterAdapterFragment(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                //return RegisterListFragment.newInstance(Constants.ACTIVE_REGISTERS_ENDPOINT);
                return new RegisterListFragment();
            case 1:
                return new Fragment();
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return "Lista de contatos";
            case 1:
                return "Criar um novo contato";
                default:
                    return "nullo";
        }
    }

    @Override
    public int getCount() {
        return FRAGMENTS_COUNT;
    }
}
