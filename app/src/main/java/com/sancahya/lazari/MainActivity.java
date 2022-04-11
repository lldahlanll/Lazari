package com.sancahya.lazari;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationBarView;
import com.sancahya.lazari.UI.DashBoardFragment;
import com.sancahya.lazari.UI.HomeFragment;
import com.sancahya.lazari.UI.KeranjangFragment;
import com.sancahya.lazari.UI.ProfileFragment;
import com.sancahya.lazari.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    Boolean isPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        checkNetworkConnection();
        binding.bottomNavigation.inflateMenu(R.menu.bottom_nav_menu);
        fragmentManager = getSupportFragmentManager();
        //inisialisasi fragment
        fragmentManager.beginTransaction().replace(R.id.fragment_container, new DashBoardFragment()).commit();
        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.navigation_home:
                        fragment = new DashBoardFragment();
                        break;
                    case R.id.navigation_feeds:
                        fragment = new HomeFragment();
                        break;
                    case R.id.navigation_keranjang:
                        fragment = new KeranjangFragment();
                        break;
                    case R.id.navigation_profile:
                        fragment = new ProfileFragment();
                        break;
                }
                final FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container, fragment).commit();
                return true;
            }
        });
    }
            @Override
            public void onBackPressed() {
                if (isPressed) {
                    finishAffinity();
                    System.exit(0);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Tap Kembali Untuk Keluar Aplikasi.",
                            Toast.LENGTH_SHORT).show();

                    isPressed = true;
                }

                Runnable runnable = () -> isPressed = false;

                new Handler().postDelayed(runnable, 2000);
            }
        }