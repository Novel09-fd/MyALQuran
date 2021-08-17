package com.novel.myal_quran;


import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.novel.myal_quran.fragment.QuranFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("Al-Quran");

        BottomNavigationView bottomNavigationView = findViewById(R.id.btn_NavView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(new QuranFragment());

    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.alquran:
                fragment = new QuranFragment();
                break;
            case R.id.jadwalSholat:
                fragment = new JadwalSholatFragment();
                break;
            case R.id.masque:
                fragment = new MasjidFragment();
                break;
        }
        return loadFragment(fragment);
    }

}