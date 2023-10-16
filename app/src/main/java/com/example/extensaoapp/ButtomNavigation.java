package com.example.extensaoapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.extensaoapp.databinding.ActivityMainBinding;
import com.example.extensaoapp.fragments.GraphicsFragment;
import com.example.extensaoapp.fragments.RegisterFragment;
import com.example.extensaoapp.fragments.SettingsFragment;
import com.example.extensaoapp.fragments.WorkHistoryFragment;

public class ButtomNavigation extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.extensaoapp.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new WorkHistoryFragment());
        binding.bottomNavigation.setBackground(null);

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.menu_work_history) {
                replaceFragment(new WorkHistoryFragment());
            } else if (item.getItemId() == R.id.menu_graphics) {
                replaceFragment(new GraphicsFragment());
            } else if (item.getItemId() == R.id.menu_register) {
                replaceFragment(new RegisterFragment());
            } else if (item.getItemId() == R.id.menu_settings) {
                replaceFragment(new SettingsFragment());
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}
