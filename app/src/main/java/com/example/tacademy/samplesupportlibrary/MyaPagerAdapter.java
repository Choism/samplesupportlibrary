package com.example.tacademy.samplesupportlibrary;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Tacademy on 2016-07-27.
 */

//ViewPager를 이용하기 위한 Adapter
public class MyaPagerAdapter extends FragmentPagerAdapter {

    public MyaPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return MessageFragment.newInstance("pager : " + position);
    }
    @Override
    public int getCount () {
        return 10;
    }
    @Override
    public CharSequence getPageTitle ( int position){
        return "tab" + position;
    }
    } //getPageTitle 탭에 보여질 이름을 넘겨주면 된다.
