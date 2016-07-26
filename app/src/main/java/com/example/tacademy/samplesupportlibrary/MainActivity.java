package com.example.tacademy.samplesupportlibrary;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView naviView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        NavigationView naviView;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        naviView = (NavigationView) findViewById(R.id.navigation_view);
        View headerView = naviView.getHeaderView(0); //HeadrView는 무족건 0
        TextView nameView = (TextView) headerView.findViewById(R.id.text_name);
        nameView.setText("ysl");
        naviView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
            case R.id.menu_delete:
            case R.id.menu_get:
                Toast.makeText(MainActivity.this, "menu : " + item.getItemId(), Toast.LENGTH_SHORT).show();

                return true;
        }
        return false;
    }
}
