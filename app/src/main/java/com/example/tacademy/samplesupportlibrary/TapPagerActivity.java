package com.example.tacademy.samplesupportlibrary;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TapPagerActivity extends AppCompatActivity {

    TabLayout tabs;
    ViewPager pager;
    MyaPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap_pager);
        tabs = (TabLayout)findViewById(R.id.tabs);
        pager = (ViewPager)findViewById(R.id.pager);
        mAdapter = new MyaPagerAdapter(getSupportFragmentManager());

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

             }

            @Override
            public void onPageSelected(int position) {
                setTitle("pager : " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        pager.setAdapter(mAdapter); //pager에 mAdapter 선언
        tabs.setupWithViewPager(pager); //tabs에 pager에서 getPageTitle 읽어 보여 줌. 실행하는 시점에서 tab을 추가 함.

        tabs.removeAllTabs(); // 탭을 다 지워줌
        for(int i = 0; i<10; i++){
            tabs.addTab(tabs.newTab().setText("TT"+i)); // 탭 새로 만들어주는 곳
        }


    }
}
