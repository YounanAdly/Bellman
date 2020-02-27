package com.example.android.bellman.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.android.bellman.Fragment.HomeFragment;
import com.example.android.bellman.AnimationLibrary.GooeyMenu;
import com.example.android.bellman.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements GooeyMenu.GooeyMenuInterface {

    private GooeyMenu mGooeyMenu;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        mGooeyMenu = (GooeyMenu) findViewById(R.id.gooey_menu);
        mGooeyMenu.setOnMenuListener(this);

        framgnetManger();

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigation);
        bottomNav.setItemIconTintList(null);
        bottomNav.getMenu().getItem(2).setEnabled(false);


        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.search:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.cup:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.profile:
                        selectedFragment = new HomeFragment();
                        break;

                }


                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
        });

    }

    private void framgnetManger() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
    }

    @Override
    public void menuOpen() {
        showToast("Menu Open");
    }

    @Override
    public void menuClose() {
        showToast( "Menu Close");
    }

    @Override
    public void menuItemClicked(int menuNumber) {
        showToast( "Menu item clicked : " + menuNumber);
    }

    private void showToast(String msg){
        if(mToast!=null){
            mToast.cancel();
        }
        mToast= Toast.makeText(this,msg,Toast.LENGTH_SHORT);
        mToast.setGravity(Gravity.CENTER,0,0);
        mToast.show();
    }

}
