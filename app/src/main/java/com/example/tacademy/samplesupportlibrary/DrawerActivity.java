package com.example.tacademy.samplesupportlibrary;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class DrawerActivity extends AppCompatActivity {
    DrawerLayout drawer;
    TextView messageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        messageView = (TextView) findViewById(R.id.text_message);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //public boolean onOptionsItemSelected(MenuItem item) 호출
        getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.ic_dialog_map);
        TextView menu = (TextView) findViewById(R.id.menu_1);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showContent("Menu 1");
            }
        });

        menu = (TextView) findViewById(R.id.menu_2);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showContent("Menu 2");
            }
        });

        menu = (TextView) findViewById(R.id.menu_3);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showContent("Menu 3");
            }
        });
    }

    private void showContent(String message) { //선택시 자동으로 사라지게 하는 곳
        messageView.setText(message);
        drawer.closeDrawer(GravityCompat.START); // 여기서 선언
    }
//메뉴 버튼 누를때  getSupportActionBar().setDisplayHomeAsUpEnabled(true); 호출
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
}