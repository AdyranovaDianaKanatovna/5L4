package com.example.a5l4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.View;

import com.example.a5l4.databinding.ActivityMainBinding;
import com.example.a5l4.prefs.Prefs;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private NavController navController;
    private ActivityMainBinding binding;
    @Inject
    Prefs prefs;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();

        prefs.save(this);
        if(!prefs.isShown()){
            navController.navigate(R.id.boardFragment3);
        }
    }
    public void onStartClick(View view){
        prefs.saveState();
        navController.navigateUp();
    }
}