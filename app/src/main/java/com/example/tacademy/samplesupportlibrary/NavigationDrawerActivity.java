package com.example.tacademy.samplesupportlibrary;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

//Action AppBar + (Drawer+Navigation) + 플래그 합친 Activity
public class NavigationDrawerActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    NavigationView naviView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));  //AppBar 설정

        drawer = (DrawerLayout)findViewById(R.id.drawer);
        naviView = (NavigationView)findViewById(R.id.navi_menu);
        naviView.setNavigationItemSelectedListener(this);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, MessageFragment.newInstance("Main"))
                    .commit();
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //Appbar home 생성
        getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.ic_dialog_info);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {  //Appbar 아이템 선택시 호출되는 부분
        if (item.getItemId() == android.R.id.home) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                drawer.openDrawer(GravityCompat.START);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_main : {
                emptyBackStack();
                break;
            }
            case R.id.menu_add : {
                emptyBackStack(); //back할 시 ublic void onBackPressed() 호출
                replaceFragment(MessageFragment.newInstance("ADD")); //replaceFragment stack을 확인하여 없을시 빈공간에 자동적 추가
                break;
            }
            case R.id.menu_get : {
                emptyBackStack(); //back할 시 ublic void onBackPressed() 호출
                replaceFragment(MessageFragment.newInstance("GET")); //replaceFragment stack을 확인하여 없을시 빈공간에 자동적 추가
                break;
            }
            case R.id.menu_delete : {
                emptyBackStack(); //back할 시 ublic void onBackPressed() 호출
                replaceFragment(MessageFragment.newInstance("DELETE")); //replaceFragment stack을 확인하여 없을시 빈공간에 자동적 추가
                break;
            }
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void emptyBackStack() {
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    private void replaceFragment(Fragment f) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, f)
                .addToBackStack(null)
                .commit();
    }

    @Override //backSteck이 다 빠져나가 빈 공간이 된다.
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
